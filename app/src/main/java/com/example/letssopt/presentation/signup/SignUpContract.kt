package com.example.letssopt.presentation.signup

interface SignUpContract {

    data class State(
        val id: String = "",
        val password: String = "",
        val passwordConfirm: String = "",
        val name: String = "",
        val email: String = "",
        val age: String = "",
        val part: String = "",
    )

    sealed class SideEffect {
        data class OnShowToast(val message: String) : SideEffect()
        data object NavigateToLogin : SideEffect()
    }
}
