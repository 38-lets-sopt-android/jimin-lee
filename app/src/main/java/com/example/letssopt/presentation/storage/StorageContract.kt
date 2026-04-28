package com.example.letssopt.presentation.storage

import com.example.letssopt.data.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface StorageContract {
    data class State(
        val storageItems: ImmutableList<ContentItemModel> = persistentListOf(),
    )
}
