package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import com.example.letssopt.data.model.UserInfo
import com.example.letssopt.presentation.login.LoginContract.LoginResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginContract.State())
    val uiState = _uiState.asStateFlow()

    fun updateEmailText(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updatePasswordText(newPW: String) {
        _uiState.update { it.copy(password = newPW) }
    }

    fun validateLogin(
        savedUserInfo: UserInfo,
    ): LoginResult {
        val state = uiState.value
        val email = state.email
        val password = state.password
        val savedEmail = savedUserInfo.email
        val savedPassword = savedUserInfo.password

        return when {
            email.isBlank() || password.isBlank() -> LoginResult.EmptyFailure
            email != savedEmail || password != savedPassword -> LoginResult.InvalidFailure
            else -> LoginResult.Success
        }
    }
}
