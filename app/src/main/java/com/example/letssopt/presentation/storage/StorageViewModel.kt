package com.example.letssopt.presentation.storage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.local.dao.StorageDao
import com.example.letssopt.data.local.entity.StorageEntity
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class StorageViewModel(
    private val storageDao: StorageDao,
) : ViewModel() {

    private val _uiState = storageDao.getStorageItems()

    val uiState = _uiState
        .map { items ->
            StorageContract.State(
                storageItems = items.map { item ->
                    StorageEntity(
                        id = item.id,
                        title = item.title,
                        img = item.img,
                    )
                }.toImmutableList()
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = StorageContract.State()
        )

    fun removeStorageItem(item: StorageEntity) {
        viewModelScope.launch {
            storageDao.deleteStorageItems(item)
        }
    }
}
