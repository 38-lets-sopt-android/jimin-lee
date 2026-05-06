package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.presentation.login.LoginContract.SideEffect.NavigateToHome
import com.example.letssopt.presentation.login.LoginContract.SideEffect.OnShowToast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val preferences: PreferencesUtil,
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginContract.State())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = Channel<LoginContract.SideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    fun updateIdText(newId: String) {
        _uiState.update { it.copy(id = newId) }
    }

    fun updatePasswordText(newPW: String) {
        _uiState.update { it.copy(password = newPW) }
    }

    fun validateLogin() = viewModelScope.launch {
        val state = uiState.value
        val id = state.id
        val password = state.password
        val savedUserInfo = preferences.getUserInfo()
        val savedId = savedUserInfo.id
        val savedPassword = savedUserInfo.password

        when {
            id.isBlank() || password.isBlank() -> _sideEffect.send(OnShowToast("아이디와 비밀번호를 입력해주세요"))
            id != savedId || password != savedPassword -> _sideEffect.send(OnShowToast("아이디 또는 비밀번호가 일치하지 않습니다"))
            else -> {
                _sideEffect.send(OnShowToast("로그인에 성공했습니다"))
                _sideEffect.send(NavigateToHome)
            }
        }
    }
}
