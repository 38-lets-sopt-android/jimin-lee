package com.example.letssopt.presentation.signup

interface SignUpContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val passwordConfirm: String = "",
    )

    sealed class SideEffect {
        data class OnShowToast(val message: String) : SideEffect()
        data object NavigateToLogin : SideEffect()
    }
}
