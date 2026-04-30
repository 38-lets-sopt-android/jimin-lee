package com.example.letssopt.presentation.purchase

import com.example.letssopt.data.local.entity.StorageEntity
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface PurchaseContract {
    data class State(
        val purchaseItems: ImmutableList<StorageEntity> = persistentListOf(),
    )
}
