package com.example.letssopt.presentation.storage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.MainTabRoute
import com.example.letssopt.presentation.storage.StorageRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToStorage(
    navOptions: NavOptions? = null,
){
    navigate(
        route = Storage,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.storageGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Storage> {
        StorageRoute(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Storage : MainTabRoute
