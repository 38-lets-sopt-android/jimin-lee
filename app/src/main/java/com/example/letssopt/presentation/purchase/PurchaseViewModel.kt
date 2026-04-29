package com.example.letssopt.presentation.purchase

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.data.model.ContentItemModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PurchaseViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PurchaseContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchPurchaseItems()
    }

    private fun fetchPurchaseItems() {
        _uiState.update {
            it.copy(
                purchaseItems =
                    persistentListOf(
                        ContentItemModel(1, R.drawable.img_home_1, "이 사랑 통역 되나요"),
                        ContentItemModel(2, R.drawable.img_home_2, "이상한일5"),
                        ContentItemModel(3, R.drawable.img_home_3, "하일매리"),
                        ContentItemModel(4, R.drawable.img_home_1, "이 사랑 통역 되나요"),
                    )
            )
        }
    }
}
