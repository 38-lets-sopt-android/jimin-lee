package com.example.letssopt.presentation.storage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun StorageEmpty(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "찜해놓은 목록이 없습니다",
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.subhead2.semibold18
        )
    }
}

@Preview
@Composable
private fun StorageEmptyPreview() {
    LETSSOPTTheme {
        StorageEmpty()
    }
}
