package com.example.letssopt.presentation.purchase

import com.example.letssopt.data.model.StorageItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface PurchaseContract {
    data class State(
        val purchaseItems: ImmutableList<StorageItemModel> = persistentListOf(),
    )

    sealed class SideEffect {
        data class OnShowToast(val message: String) : SideEffect()
    }
}
