package com.example.letssopt.presentation.storage

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun StorageScreen (
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "보관함 화면입니다.",
            color = LETSSOPTTheme.colors.txtPrimary,
        )
    }
}

@Preview
@Composable
private fun StorageScreenPreview() {
    LETSSOPTTheme {
        StorageScreen()
    }
}
