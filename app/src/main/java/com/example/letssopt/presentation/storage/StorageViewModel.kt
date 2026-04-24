package com.example.letssopt.presentation.storage

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.data.model.ContentItemModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StorageViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(StorageContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchStorageItems()
    }

    private fun fetchStorageItems() {
        _uiState.update {
            it.copy(
                storageItems =
                    persistentListOf(
                        ContentItemModel(1, R.drawable.img_home_1),
                        ContentItemModel(2, R.drawable.img_home_2),
                        ContentItemModel(3, R.drawable.img_home_3),
                        ContentItemModel(4, R.drawable.img_home_1),
                    )
            )
        }
    }

   fun removeStorageItem(id: Int) {
        _uiState.update {
            it.copy(
                storageItems = it.storageItems.filter { it.id != id }.toImmutableList()
            )
        }
   }
}
