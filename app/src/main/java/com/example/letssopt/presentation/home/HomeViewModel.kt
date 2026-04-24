package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.WatgoritmItemModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchNewContentItems()
        fetchWatgorithmItems()
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

    private fun fetchWatgorithmItems() {
        _uiState.update {
            it.copy(
                watgorithmItems =
                    persistentListOf(
                        WatgoritmItemModel(1, R.drawable.img_home_1),
                        WatgoritmItemModel(2, R.drawable.img_home_2),
                        WatgoritmItemModel(3, R.drawable.img_home_3),
                        WatgoritmItemModel(4, R.drawable.img_home_1),
                        WatgoritmItemModel(5, R.drawable.img_home_2),
                        WatgoritmItemModel(6, R.drawable.img_home_3),
                    )
            )
        }
    }
}
