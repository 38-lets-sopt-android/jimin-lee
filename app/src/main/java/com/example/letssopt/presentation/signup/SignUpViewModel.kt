package com.example.letssopt.presentation.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpContract.State())
    val uiState = _uiState.asStateFlow()

    val isBtnEnabled: Boolean
        get() = uiState.value.email.isNotEmpty() &&
                uiState.value.password.isNotEmpty() &&
                uiState.value.passwordConfirm.isNotEmpty()

    fun checkValidation(
        onFailure: (String) -> Unit,
        onSuccess: () -> Unit,
    ) {
        val email = _uiState.value.email
        val password = _uiState.value.password
        val passwordConfirm = _uiState.value.passwordConfirm

        val isEmailValid = email.matches(EMAIL_REGEX)
        val isPasswordValid = password.length in 8..12
        val isPasswordMatch = password == passwordConfirm

        when {
            !isEmailValid -> onFailure("이메일 형식이 잘못되었습니다")
            !isPasswordValid -> onFailure("비밀번호는 8~12자로 입력해주세요")
            !isPasswordMatch -> onFailure("비밀번호가 일치하지 않습니다")
            else -> onSuccess()
        }
    }

    fun updateEmailText(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updatePasswordText(newPW: String) {
        _uiState.update { it.copy(password = newPW) }
    }

    fun updatePasswordConfirmText(newPWConfirm: String) {
        _uiState.update { it.copy(passwordConfirm = newPWConfirm) }
    }

    companion object {
        private val EMAIL_REGEX =Regex ("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    }
}
