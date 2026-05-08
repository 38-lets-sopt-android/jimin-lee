package com.example.letssopt.presentation.user

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.datasource.UserRemoteDataSourceImpl
import com.example.letssopt.data.remote.repository.UserRepositoryImpl

class UserViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(
                UserRepositoryImpl(
                    PreferencesUtil(context), UserRemoteDataSourceImpl(RetrofitClient.userService)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
