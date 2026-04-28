package com.example.letssopt.presentation.login

interface LoginContract {

    data class State(
        val email: String = "",
        val password: String = "",
    )

    sealed class LoginResult {
        data object EmptyFailure : LoginResult()

        data object InvalidFailure : LoginResult()

        data object Success : LoginResult()
    }
}
