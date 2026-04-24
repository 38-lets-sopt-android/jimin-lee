package com.example.letssopt.presentation.main

import com.example.letssopt.presentation.main.component.MainTab
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

interface MainContract {

    data class State(
        val selectedItem: MainTab = MainTab.MAIN,
        val items: ImmutableList<MainTab> = MainTab.entries.toImmutableList()
    )
}
