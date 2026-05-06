package com.example.letssopt.data.mapper

import com.example.letssopt.data.local.entity.StorageEntity
import com.example.letssopt.data.model.StorageItemModel

fun StorageItemModel.toEntity() = StorageEntity(
    id = this.id,
    title = this.title,
    img = this.img,
)
