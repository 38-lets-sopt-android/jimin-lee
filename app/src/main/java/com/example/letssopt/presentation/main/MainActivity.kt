package com.example.letssopt.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.component.LetsSoptTopBar
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.HomeRoute
import com.example.letssopt.presentation.main.component.LetsSoptBottomBar
import com.example.letssopt.presentation.main.component.MainTab
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.storage.StorageRoute
import com.example.letssopt.presentation.webtoon.WebtoonScreen
import kotlinx.collections.immutable.ImmutableList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                MainRoute(modifier = Modifier)
            }
        }
    }
}

@Composable
private fun MainRoute(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MainScreen(
        items = uiState.items,
        selectedItem = uiState.selectedItem,
        onItemSelected = viewModel::updateSelectedItem,
        modifier = modifier,
    )
}


@Composable
private fun MainScreen(
    items: ImmutableList<MainTab>,
    selectedItem: MainTab,
    onItemSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (selectedItem == MainTab.HOME) {
                LetsSoptTopBar(
                    modifier = modifier.statusBarsPadding(),
                )
            }
        },
        bottomBar = {
            LetsSoptBottomBar(
                items = items,
                selectedItem = selectedItem,
                onItemSelected = onItemSelected,
                modifier = Modifier.navigationBarsPadding()
            )
        },
        containerColor = LETSSOPTTheme.colors.background,
    ) { innerPadding ->

        when (selectedItem) {
            MainTab.HOME -> HomeRoute(modifier = Modifier.padding(innerPadding))
            MainTab.PURCHASE -> PurchaseScreen(modifier = Modifier.padding(innerPadding))
            MainTab.SEARCH -> SearchScreen(modifier = Modifier.padding(innerPadding))
            MainTab.WEBTOON -> WebtoonScreen(modifier = Modifier.padding(innerPadding))
            MainTab.STORAGE -> StorageRoute(modifier = Modifier.padding(innerPadding))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainRoutePreview() {
    LETSSOPTTheme {
        MainScreen(
            items = MainContract.State().items,
            selectedItem = MainContract.State().selectedItem,
            onItemSelected = {},
        )
    }
}
