package com.example.letssopt.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.extension.noRippleClickable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun LetsSoptBottomBar(
    items: ImmutableList<MainTab>,
    selectedItem: MainTab,
    onItemSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LETSSOPTTheme.colors.background,
            )
            .padding(top = 15.dp, bottom = 12.dp)
            .padding(horizontal = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(21.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEach { item ->
            BottomBarItem(
                icon = item.icon,
                label = item.label,
                modifier = Modifier.noRippleClickable(
                    onClick = { onItemSelected(item) }
                ),
                isSelected = selectedItem == item
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    @DrawableRes icon: Int,
    label: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    val color = if (isSelected) LETSSOPTTheme.colors.txtPrimary else LETSSOPTTheme.colors.disabled

    Column(
        modifier = modifier.widthIn(48.dp),
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
            style = LETSSOPTTheme.typography.body2.regular12,
        )
    }
}

@Preview
@Composable
private fun LetsSoptBottomBarPreview() {
    LETSSOPTTheme {
        var selectedItem by remember { mutableStateOf(MainTab.HOME) }

        LetsSoptBottomBar(
            items = MainTab.entries.toImmutableList(),
            selectedItem = MainTab.HOME,
            onItemSelected = { selectedItem = it },
        )
    }
}
