package com.example.letssopt.presentation.search

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
) {
    SearchScreen(modifier = modifier)
}

@Composable
private fun SearchScreen (
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "검색 화면입니다.",
            color = LETSSOPTTheme.colors.txtPrimary,
        )
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    LETSSOPTTheme {
        SearchScreen()
    }
}
