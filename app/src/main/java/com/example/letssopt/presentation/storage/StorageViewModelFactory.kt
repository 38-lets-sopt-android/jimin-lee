package com.example.letssopt.presentation.storage

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.data.local.AppDatabase

class StorageViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StorageViewModel::class.java)) {
            val dao = AppDatabase.getDatabase(context).storageDao()
            @Suppress("UNCHECKED_CAST")
            return StorageViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
