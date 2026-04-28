package com.example.letssopt.presentation.home.model

import androidx.annotation.DrawableRes

data class HomePartyItemModel (
    val id: Int,
    @DrawableRes val img: Int,
    val time: String,
    val title: String,
)
