package com.example.letssopt.presentation.profile

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.datasource.ProfileRemoteDataSourceImpl
import com.example.letssopt.data.remote.repository.ProfileRepositoryImpl

class ProfileViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(
                ProfileRepositoryImpl(
                    PreferencesUtil(context),
                    ProfileRemoteDataSourceImpl(RetrofitClient.profileService)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
