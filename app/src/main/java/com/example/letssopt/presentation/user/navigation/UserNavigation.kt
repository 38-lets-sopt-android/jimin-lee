package com.example.letssopt.presentation.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.user.UserRoute
import kotlinx.serialization.Serializable

fun NavController.navigateToUser(
    navOptions: NavOptions? = null,
){
    navigate(
        route = User,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.userGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<User> {
        UserRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object User : Route
