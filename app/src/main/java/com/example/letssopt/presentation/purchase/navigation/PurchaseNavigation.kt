package com.example.letssopt.presentation.purchase.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.core.navigation.MainTabRoute
import com.example.letssopt.presentation.purchase.PurchaseRoute
import kotlinx.serialization.Serializable

fun NavGraphBuilder.purchaseGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Purchase> {
        PurchaseRoute(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Serializable
data object Purchase : MainTabRoute
