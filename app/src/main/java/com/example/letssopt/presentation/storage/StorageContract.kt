package com.example.letssopt.presentation.storage

import com.example.letssopt.data.local.entity.StorageEntity
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface StorageContract {
    data class State(
        val storageItems: ImmutableList<StorageEntity> = persistentListOf(),
    )
}
