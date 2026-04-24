package com.example.letssopt.presentation.home

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface HomeContract {
    data class State(
        val newContentItems: ImmutableList<Int> = persistentListOf(),
    )
}
