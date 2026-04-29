package com.example.letssopt.presentation.webtoon.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.MainTabRoute
import com.example.letssopt.presentation.webtoon.WebtoonRoute
import kotlinx.serialization.Serializable

fun NavGraphBuilder.webtoonGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Webtoon> {
        WebtoonRoute(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Webtoon : MainTabRoute
