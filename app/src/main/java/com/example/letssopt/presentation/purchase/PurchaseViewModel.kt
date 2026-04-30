package com.example.letssopt.presentation.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.R
import com.example.letssopt.data.local.dao.StorageDao
import com.example.letssopt.data.local.entity.StorageEntity
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PurchaseViewModel(
    private val storageDao: StorageDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(PurchaseContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchPurchaseItems()
    }

    fun addStorageItems(item: StorageEntity) {
        viewModelScope.launch {
            storageDao.insertStorageItems(
                StorageEntity(
                    id = item.id,
                    title = item.title,
                    img = item.img)
            )
        }
    }

    private fun fetchPurchaseItems() {
        _uiState.update {
            it.copy(
                purchaseItems =
                    persistentListOf(
                        StorageEntity(id = 1L, title = "이 사랑 통역 되나요", img = R.drawable.img_home_1),
                        StorageEntity(id = 2L, title = "이상한일5", img = R.drawable.img_home_2),
                        StorageEntity(id = 3L, title = "하일매리", img = R.drawable.img_home_3),
                        StorageEntity(id = 4L, title = "이 사랑 통역 되나요", img = R.drawable.img_home_1),
                    )
            )
        }
    }
}
