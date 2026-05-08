package com.example.letssopt.presentation.profile.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.Route
import com.example.letssopt.presentation.profile.ProfileRoute
import com.example.letssopt.presentation.user.navigation.navigateToUser
import kotlinx.serialization.Serializable

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null,
){
    navigate(
        route = Profile,
        navOptions = navOptions,
    )
}

fun NavGraphBuilder.profileGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Profile> {
        ProfileRoute(
            navigateToUser = navController::navigateToUser,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Profile : Route
