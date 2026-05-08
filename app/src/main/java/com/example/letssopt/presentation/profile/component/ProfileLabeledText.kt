package com.example.letssopt.presentation.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun ProfileLabeledText(
    label: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ){
        Text(
            text = label,
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.h3.bold16,
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = content,
            color = LETSSOPTTheme.colors.txtSecondary,
            style = LETSSOPTTheme.typography.caption1.regular14,
        )
    }
}

@Preview
@Composable
private fun ProfileLabeledTextPreview() {
    LETSSOPTTheme {
        ProfileLabeledText(
            label = "아이디",
            content = "아이디아이디"
        )
    }
}
