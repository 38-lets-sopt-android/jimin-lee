package com.example.letssopt.presentation.storage

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
import com.example.letssopt.presentation.storage.component.StorageEmpty
import com.example.letssopt.presentation.storage.component.StorageItem
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StorageRoute(
    modifier: Modifier = Modifier,
    viewModel: StorageViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    StorageScreen(
        items = uiState.storageItems,
        onDeleteClick = { viewModel.removeStorageItem(it) },
        modifier = modifier,
    )
}

@Composable
private fun StorageScreen(
    items: List<ContentItemModel>,
    onDeleteClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 70.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "찜한 목록",
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.h3.semibold20
        )

        Spacer(modifier = Modifier.height(35.dp))

        if (items.isEmpty()) {
            StorageEmpty()
        } else {

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
                    StorageItem(
                        item = item,
                        onDeleteClick = { onDeleteClick(item.id) },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun StorageScreenPreview() {
    LETSSOPTTheme {
        StorageScreen(
            items = persistentListOf(
                ContentItemModel(1, R.drawable.img_home_1),
                ContentItemModel(2, R.drawable.img_home_2),
                ContentItemModel(3, R.drawable.img_home_3),
                ContentItemModel(4, R.drawable.img_home_1),
            ),
            onDeleteClick = {},
        )
    }
}
