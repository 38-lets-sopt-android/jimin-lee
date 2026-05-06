package com.example.letssopt.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.presentation.signup.SignUpContract.SideEffect.NavigateToLogin
import com.example.letssopt.presentation.signup.SignUpContract.SideEffect.OnShowToast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val preferences: PreferencesUtil,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpContract.State())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = Channel<SignUpContract.SideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    val isBtnEnabled: Boolean
        get() = uiState.value.id.isNotEmpty() &&
                uiState.value.password.isNotEmpty() &&
                uiState.value.passwordConfirm.isNotEmpty()

    fun checkValidation() = viewModelScope.launch {
        val id = _uiState.value.id
        val password = _uiState.value.password
        val passwordConfirm = _uiState.value.passwordConfirm

        val isIdValid = id.matches(ID_REGEX)
        val isPasswordValid = password.length in 8..12
        val isPasswordMatch = password == passwordConfirm


        when {
            !isIdValid -> _sideEffect.send(OnShowToast("아이디는 영어,숫자,기호(._%+-)만 입력해주세요"))
            !isPasswordValid -> _sideEffect.send(OnShowToast("비밀번호는 8~12자로 입력해주세요"))
            !isPasswordMatch -> _sideEffect.send(OnShowToast("비밀번호가 일치하지 않습니다"))
            else -> {
                preferences.setUserInfo(
                    id = id,
                    password = password,
                )
                _sideEffect.send(OnShowToast("회원가입이 완료되었습니다."))
                _sideEffect.send(NavigateToLogin)
            }
        }
    }

    fun updateIdText(newId: String) {
        _uiState.update { it.copy(id = newId) }
    }

    fun updatePasswordText(newPW: String) {
        _uiState.update { it.copy(password = newPW) }
    }

    fun updatePasswordConfirmText(newPWConfirm: String) {
        _uiState.update { it.copy(passwordConfirm = newPWConfirm) }
    }

    companion object {
        private val ID_REGEX = Regex("^[a-zA-Z0-9._%+-]+$")
    }
}
