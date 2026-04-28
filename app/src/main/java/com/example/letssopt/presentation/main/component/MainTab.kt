package com.example.letssopt.presentation.main.component

import androidx.annotation.DrawableRes
import com.example.letssopt.R

enum class MainTab(
    @param:DrawableRes val icon: Int,
    val label: String,
) {
    HOME(
        icon = R.drawable.ic_home,
        label = "메인",
    ),
    PURCHASE(
        icon = R.drawable.ic_purchase,
        label = "개별 구매",
    ),
    WEBTOON(
        icon = R.drawable.ic_webtoon,
        label = "웹툰",
    ),
    SEARCH(
        icon = R.drawable.ic_search,
        label = "찾기",
    ),
    STORAGE(
        icon = R.drawable.ic_storage,
        label = "보관함",
    );
}
