package com.example.letssopt.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.main.component.BottomBarItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun LetsSoptBottomBar(
    items: ImmutableList<BottomBarItem>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 11.dp, horizontal = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(21.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEach { item ->
            BottomBarItem(
                icon = item.icon,
                label = item.label,
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    @DrawableRes icon: Int,
    label: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    val color = if (isEnabled) LETSSOPTTheme.colors.txtPrimary else LETSSOPTTheme.colors.disabled

    Column(
        modifier = modifier
            .widthIn(48.dp)
            .heightIn(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = color,
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = label,
            color = color,
        )
    }
}

@Preview
@Composable
private fun LetsSoptBottomBarPreview() {
    LETSSOPTTheme {
        LetsSoptBottomBar(
            items = BottomBarItem.entries.toImmutableList(),
        )
    }
}
