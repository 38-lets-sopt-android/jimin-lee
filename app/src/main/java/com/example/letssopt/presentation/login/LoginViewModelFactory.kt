package com.example.letssopt.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.datasource.AuthRemoteDataSourceImpl
import com.example.letssopt.data.remote.repository.AuthRepositoryImpl

class LoginViewModelFactory(
    private val context: Context,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val authRepository = AuthRepositoryImpl(PreferencesUtil(context.applicationContext),AuthRemoteDataSourceImpl(RetrofitClient.authService))
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
