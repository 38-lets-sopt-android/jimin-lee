package com.example.letssopt.presentation.login

interface LoginContract {

    data class State(
        val id: String = "",
        val password: String = "",
    )

    sealed class SideEffect {
        data class OnShowToast(val message: String) : SideEffect()
        data object NavigateToHome : SideEffect()
        data object NavigateToSignUp : SideEffect()
    }
}
