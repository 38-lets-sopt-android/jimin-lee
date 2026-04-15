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

    fun updateEmailText(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updatePasswordText(newPW: String) {
        _uiState.update { it.copy(password = newPW) }
    }

    fun updatePasswordConfirmText(newPWConfirm: String) {
        _uiState.update { it.copy(passwordConfirm = newPWConfirm) }
    }
}
