package com.example.letssopt.presentation.home

import com.example.letssopt.presentation.home.model.HomeItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface HomeContract {
    data class State(
        val newContentItems: ImmutableList<Int> = persistentListOf(),
        val homeItems: ImmutableList<HomeItemModel> = persistentListOf(),
    )
}
