package com.example.letssopt.presentation.signup

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.datasource.AuthRemoteDataSourceImpl
import com.example.letssopt.data.remote.repository.AuthRepositoryImpl

class SignUpViewModelFactory(
    private val context: Context,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            val authRepository = AuthRepositoryImpl(PreferencesUtil(context.applicationContext), AuthRemoteDataSourceImpl(RetrofitClient.authService))
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
