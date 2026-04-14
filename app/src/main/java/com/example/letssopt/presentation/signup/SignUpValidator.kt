package com.example.letssopt.presentation.signup

object SignUpValidator {
    private val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private val passwordRegex = Regex("^.{8,12}$")

    fun checkValidation(
        email: String,
        password: String,
        passwordConfirm: String,
        onFailure: (String) -> Unit,
        onSuccess: (String, String) -> Unit,
    ) {
        val isEmailValid = email.matches(emailRegex)
        val isPasswordValid = password.matches(passwordRegex)
        val isPasswordMatch = password == passwordConfirm

        when {
            !isEmailValid -> onFailure("이메일 형식이 잘못되었습니다")
            !isPasswordValid -> onFailure("비밀번호는 8~12자로 입력해주세요")
            !isPasswordMatch -> onFailure("비밀번호가 일치하지 않습니다")
            else -> onSuccess(email, password)
        }
    }
}
