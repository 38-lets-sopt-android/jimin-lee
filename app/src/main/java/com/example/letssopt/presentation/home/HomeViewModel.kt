package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchNewContentItems()
    }

    fun fetchNewContentItems() {
        _uiState.update {
            it.copy(
                newContentItems =
                    persistentListOf(
                        R.drawable.img_home_newcontent_1,
                        R.drawable.img_home_newcontent_2,
                        R.drawable.img_home_newcontent_3,
                    )
            )
        }
    }
}
