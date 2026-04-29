package com.example.letssopt.presentation.purchase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.data.model.ContentItemModel
import com.example.letssopt.presentation.purchase.component.PurchaseItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun PurchaseRoute(
    modifier: Modifier = Modifier,
    viewModel: PurchaseViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PurchaseScreen(
        items = uiState.purchaseItems,
        onSaveClick = { },
        modifier = modifier,
    )
}

@Composable
private fun PurchaseScreen(
    items: ImmutableList<ContentItemModel>,
    onSaveClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 70.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "개별 구매",
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.h3.semibold20
        )

        Spacer(modifier = Modifier.height(35.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            items(
                items = items,
                key = { it.id }
            ) { item ->
                PurchaseItem(
                    item = item,
                    onSaveClick = { onSaveClick(item.id) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun PurchaseScreenPreview() {
    LETSSOPTTheme {
        PurchaseScreen(
            items = persistentListOf(
                ContentItemModel(1, R.drawable.img_home_1, "이 사랑 통역 되나요"),
                ContentItemModel(2, R.drawable.img_home_2, "이상한일5"),
                ContentItemModel(3, R.drawable.img_home_3, "하일매리"),
                ContentItemModel(4, R.drawable.img_home_1, "이 사랑 통역 되나요"),
            ),
            onSaveClick = {},
        )
    }
}
