package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.HomeItemModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchNewContentItems()
        fetchHomeItems()
    }

    private fun fetchNewContentItems() {
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

    private fun fetchHomeItems() {
        _uiState.update {
            it.copy(
                homeItems =
                    persistentListOf(
                        HomeItemModel(1, R.drawable.img_home_1),
                        HomeItemModel(2, R.drawable.img_home_2),
                        HomeItemModel(3, R.drawable.img_home_3),
                        HomeItemModel(4, R.drawable.img_home_1),
                        HomeItemModel(5, R.drawable.img_home_2),
                        HomeItemModel(6, R.drawable.img_home_3),
                    )
            )
        }
    }
}
