package com.example.letssopt.presentation.home

import com.example.letssopt.presentation.home.model.HomeContentItemModel
import com.example.letssopt.presentation.home.model.HomePartyItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface HomeContract {
    data class State(
        val newContentItems: ImmutableList<Int> = persistentListOf(),
        val homeItems: ImmutableList<HomeContentItemModel> = persistentListOf(),
        val homePartyItems: ImmutableList<HomePartyItemModel> = persistentListOf(),
    )
}
