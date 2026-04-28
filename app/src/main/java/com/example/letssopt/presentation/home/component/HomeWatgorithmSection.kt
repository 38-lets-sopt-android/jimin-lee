package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.data.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

private const val ASPECT_RATIO = 2/3f

@Composable
fun HomeWatgorithmSection(
    items: ImmutableList<ContentItemModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.img_watgorithm),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(width = 80.dp, height = 26.dp),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "예능부터 드라마까지!",
                color = LETSSOPTTheme.colors.txtSecondary,
                style = LETSSOPTTheme.typography.subhead1.semibold20,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "더보기",
                color = LETSSOPTTheme.colors.txtSecondary,
                style = LETSSOPTTheme.typography.caption2.light12,
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = items,
                key = { it.id }
            ) { item ->
                Image(
                    painter = painterResource(item.img),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .aspectRatio(ASPECT_RATIO)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = false)
private fun HomeWatgorithmSectionPreview() {
    LETSSOPTTheme {
        HomeWatgorithmSection(
            items = persistentListOf(
                ContentItemModel(1, R.drawable.img_home_1),
                ContentItemModel(2, R.drawable.img_home_2),
                ContentItemModel(3, R.drawable.img_home_3),
            )
        )
    }
}
