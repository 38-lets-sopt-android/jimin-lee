package com.example.letssopt.presentation.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.remote.repository.UserRepository
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchUserListInfo()
    }

    fun fetchUserListInfo() = viewModelScope.launch {
        userRepository.getUserList()
            .onSuccess { userInfo ->
                _uiState.update { currentState ->
                    currentState.copy(
                        userList = userInfo.userList.toImmutableList(),
                    )
                }
            }
            .onFailure { error ->
                Log.d("User", "유저 목록을 불러올 수 없습니다.")
            }
    }
}
