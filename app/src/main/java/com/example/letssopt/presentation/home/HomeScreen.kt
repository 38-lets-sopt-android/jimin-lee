package com.example.letssopt.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.component.HomeNewContentBanner
import com.example.letssopt.presentation.home.component.HomePartySection
import com.example.letssopt.presentation.home.component.HomeUpcomingSection
import com.example.letssopt.presentation.home.component.HomeWatgorithmSection
import com.example.letssopt.presentation.home.component.LetsSoptTopBar


@Composable
fun HomeRoute(
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        navigateToProfile = navigateToProfile,
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeContract.State,
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState(pageCount = { Int.MAX_VALUE })
    val newContentItems = uiState.newContentItems
    val totalPage = newContentItems.size

    LaunchedEffect(totalPage) {
        var initialPage = Int.MAX_VALUE / 2

        while (initialPage % totalPage != 0) {
            initialPage++
        }
        pagerState.scrollToPage(initialPage)
    }

    Column(
        modifier = modifier,
    ){
        LetsSoptTopBar(
            navigateToProfile = navigateToProfile,
            modifier = Modifier.statusBarsPadding(),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = LETSSOPTTheme.colors.background,
                )
                .verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            HomeNewContentBanner(
                newContentItems = newContentItems,
                pagerState = pagerState,
            )

            Spacer(modifier = Modifier.height(26.dp))

            HomeWatgorithmSection(
                items = uiState.homeItems,
            )

            Spacer(modifier = Modifier.height(26.dp))

            HomeUpcomingSection(
                items = uiState.homeItems,
            )

            Spacer(modifier = Modifier.height(26.dp))

            HomePartySection(
                items = uiState.homePartyItems,
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeScreen(
            uiState = HomeContract.State(),
            navigateToProfile = {},
        )
    }
}
