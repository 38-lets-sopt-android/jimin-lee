package com.example.letssopt.presentation.main.component

import androidx.annotation.DrawableRes
import com.example.letssopt.R
import com.example.letssopt.core.navigation.MainTabRoute
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.home.navigation.Home
import com.example.letssopt.presentation.purchase.navigation.Purchase
import com.example.letssopt.presentation.search.navigation.Search
import com.example.letssopt.presentation.storage.navigation.Storage
import com.example.letssopt.presentation.webtoon.navigation.Webtoon

enum class MainTab(
    @param:DrawableRes val icon: Int,
    val label: String,
    val route: MainTabRoute
) {
    HOME(
        icon = R.drawable.ic_home,
        label = "메인",
        route = Home,
    ),
    PURCHASE(
        icon = R.drawable.ic_purchase,
        label = "개별 구매",
        route = Purchase,
    ),
    WEBTOON(
        icon = R.drawable.ic_webtoon,
        label = "웹툰",
        route = Webtoon,
    ),
    SEARCH(
        icon = R.drawable.ic_search,
        label = "찾기",
        route = Search,
    ),
    STORAGE(
        icon = R.drawable.ic_storage,
        label = "보관함",
        route = Storage,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
