package com.example.letssopt.presentation.main

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.letssopt.core.designsystem.component.LetsSoptTopBar
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.main.component.LetsSoptBottomBar
import com.example.letssopt.presentation.main.component.MainTab
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    appState: MainAppState = rememberMainAppState(),
) {
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()
    val isBottomBarVisible by appState.isBottomBarVisible.collectAsStateWithLifecycle()
    val isHomeTab = currentTab == MainTab.HOME

    val activity = LocalActivity.current

    BackHandler(enabled = currentTab != null) {
        if (isHomeTab) {
            activity?.finish()
        } else {
            appState.navigate(MainTab.HOME)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (isHomeTab) {
                LetsSoptTopBar(
                    modifier = Modifier.statusBarsPadding(),
                )
            }
        },
        bottomBar = {
            LetsSoptBottomBar(
                isVisible = isBottomBarVisible,
                items = MainTab.entries.toPersistentList(),
                selectedItem = currentTab,
                onItemSelected = appState::navigate,
                modifier = Modifier.navigationBarsPadding()
            )
        },
        containerColor = LETSSOPTTheme.colors.background,
    ) { innerPadding ->

        MainNavHost(
            appState = appState,
            innerPadding = innerPadding,
        )
    }
}
