package com.example.letssopt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage")
data class StorageEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val img: Int,
)
