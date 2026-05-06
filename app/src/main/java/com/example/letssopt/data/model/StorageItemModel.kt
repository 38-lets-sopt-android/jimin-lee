package com.example.letssopt.data.model

import androidx.annotation.DrawableRes

data class StorageItemModel(
    val id: Long,
    val title: String,
    @DrawableRes val img: Int,
)
