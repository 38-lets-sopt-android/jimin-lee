package com.example.letssopt.presentation.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.extension.clearBackStackWithRestoreNavOptions
import com.example.letssopt.core.navigation.MainTabRoute
import com.example.letssopt.presentation.search.SearchRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToSearch(
    navOptions: NavOptions? = clearBackStackWithRestoreNavOptions(),
){
    navigate(
        route = Search,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.searchGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Search> {
        SearchRoute(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Search : MainTabRoute
