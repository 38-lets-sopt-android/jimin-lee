package com.example.letssopt.presentation.profile

interface ProfileContract {
    data class State(
        val id: String = "",
        val name: String = "",
        val email: String = "",
        val age: String = "",
        val part: String = "",
    )
}
