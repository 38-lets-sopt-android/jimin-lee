package com.example.letssopt.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.mapper.auth.toPostSignUpRequestDto
import com.example.letssopt.data.model.SignUpModel
import com.example.letssopt.data.remote.dto.toErrorResponse
import com.example.letssopt.data.remote.repository.AuthRepository
import com.example.letssopt.presentation.signup.SignUpContract.SideEffect.NavigateToLogin
import com.example.letssopt.presentation.signup.SignUpContract.SideEffect.OnShowToast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpContract.State())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = Channel<SignUpContract.SideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    val isBtnEnabled: Boolean
        get() = uiState.value.id.isNotEmpty() &&
                uiState.value.password.isNotEmpty() &&
                uiState.value.passwordConfirm.isNotEmpty() &&
                uiState.value.name.isNotEmpty() &&
                uiState.value.email.isNotEmpty() &&
                uiState.value.age.isNotEmpty() &&
                uiState.value.part.isNotEmpty()

    fun checkValidation() = viewModelScope.launch {
        val state = _uiState.value
        val id = state.id
        val password = state.password
        val passwordConfirm = state.passwordConfirm
        val name = state.name
        val email = state.email
        val age = state.age.toInt()
        val part = state.part

        val isIdValid = id.length in 4..20
        val isPasswordValid = password.length in 8..20
        val isPasswordMatch = password == passwordConfirm
        val isNameValid = name.length in 1..10
        val isEmailValid = email.matches(EMAIL_REGEX)
        val isAgeValid = age in 1..150
        val isPartValid = part == "iOS" || part == "안드로이드" || part == "웹"


        when {
            !isIdValid -> _sideEffect.send(OnShowToast("아이디는 4~20자로 입력해주세요"))
            !isPasswordValid -> _sideEffect.send(OnShowToast("비밀번호는 8~20자로 입력해주세요"))
            !isPasswordMatch -> _sideEffect.send(OnShowToast("비밀번호가 일치하지 않습니다"))
            !isNameValid -> _sideEffect.send(OnShowToast("이름은 10자 이하로 입력해주세요"))
            !isEmailValid -> _sideEffect.send(OnShowToast("이메일 형식이 올바르지 않습니다"))
            !isAgeValid -> _sideEffect.send(OnShowToast("나이는 1 이상, 150 이하로 입력해주세요"))
            !isPartValid -> _sideEffect.send(OnShowToast("파트는 iOS, 안드로이드, 웹 중 하나로 입력해주세요"))
            else -> {
                val request = SignUpModel(
                    id = id,
                    password = password,
                    name = name,
                    email = email,
                    age = age,
                    part = part,
                ).toPostSignUpRequestDto()
                authRepository.postSignUp(request)
                    .onSuccess {
                        _sideEffect.send(OnShowToast("회원가입이 완료되었습니다."))
                        _sideEffect.send(NavigateToLogin)
                    }
                    .onFailure { error ->
                        val errorStatus = error.toErrorResponse()
                        when(errorStatus) {
                            400 -> _sideEffect.send(OnShowToast("유효하지 않은 파트입니다."))
                            409 -> _sideEffect.send(OnShowToast("이미 사용 중인 아이디입니다."))
                            else -> _sideEffect.send(OnShowToast("$errorStatus"))
                        }
                    }
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

    fun updateNameText(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun updateEmailText(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun updateAgeText(newAge: String) {
        _uiState.update { it.copy(age = newAge) }
    }

    fun updatePartText(newPart: String) {
        _uiState.update { it.copy(part = newPart) }
    }

    companion object {
        private val EMAIL_REGEX = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    }
}
