package com.example.letssopt.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTTheme

@Composable
fun LetsSoptButton(
    btnText: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = LETSSOPTTheme.colors.primaryRed,
            contentColor = LETSSOPTTheme.colors.txtPrimary,
            disabledContainerColor = LETSSOPTTheme.colors.disabled,
            disabledContentColor = LETSSOPTTheme.colors.placeholder
        ),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(
            vertical = 16.dp,
        )
    ) {
        Text(
            text = btnText,
            modifier = Modifier,
            style = LETSSOPTTheme.typography.body.regular16,
        )
    }
}

@Preview
@Composable
private fun LetsSoptButtonPreview() {
    LETSSOPTTheme {
        Column {
            LetsSoptButton(
                btnText = "로그인",
                enabled = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(10.dp))

            LetsSoptButton(
                btnText = "로그인",
                enabled = false,
                onClick = {}
            )
        }
    }
}
