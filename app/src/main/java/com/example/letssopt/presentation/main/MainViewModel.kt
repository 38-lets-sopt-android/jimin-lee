package com.example.letssopt.presentation.main

import androidx.lifecycle.ViewModel
import com.example.letssopt.presentation.main.component.MainTab
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(MainContract.State())
    val uiState = _uiState.asStateFlow()

    fun updateSelectedItem(newItem: MainTab) {
        _uiState.update { it.copy(selectedItem = newItem) }
    }

}
