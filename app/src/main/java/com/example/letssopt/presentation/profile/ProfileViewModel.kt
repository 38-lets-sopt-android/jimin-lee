package com.example.letssopt.presentation.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.remote.dto.toErrorResponse
import com.example.letssopt.data.remote.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchProfileInfo()
    }

    fun fetchProfileInfo() = viewModelScope.launch {
        userRepository.getUserInfo()
            .onSuccess { userInfo ->
                _uiState.update { currentState ->
                    currentState.copy(
                        id = userInfo.loginId,
                        name = userInfo.name,
                        email = userInfo.email,
                        age = userInfo.age.toString(),
                        part = userInfo.part,
                    )
                }
            }
            .onFailure { error ->
                val errorStatus = error.toErrorResponse()
                when (errorStatus) {
                    404 -> Log.d("Profile", "존재하지 않는 유저입니다.")
                }
            }
    }
}
