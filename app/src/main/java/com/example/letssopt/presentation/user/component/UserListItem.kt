package com.example.letssopt.presentation.user.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme

@Composable
fun UserListItem(
    id: String,
    name: String,
    part: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = LETSSOPTTheme.colors.txtPrimary,
            )
            .padding(start = 68.dp, end = 34.dp)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = id,
                color = LETSSOPTTheme.colors.txtPrimary,
                style = LETSSOPTTheme.typography.h3.bold16
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = name,
                color = LETSSOPTTheme.colors.txtSecondary,
                style = LETSSOPTTheme.typography.caption1.regular14,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = part,
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.caption1.regular14,
        )

    }
}

@Preview
@Composable
private fun UserListItemPreview() {
    LETSSOPTTheme {
        UserListItem(
            id = "235",
            name = "안녕",
            part = "안드로이드"
        )
    }
}
