package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.model.HomePartyItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

private const val ASPECT_RATIO = 49 / 34f

@Composable
fun HomePartySection(
    items: ImmutableList<HomePartyItemModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = "왓챠 파티",
                color = LETSSOPTTheme.colors.txtPrimary,
                style = LETSSOPTTheme.typography.subhead1.semibold20,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "더보기",
                color = LETSSOPTTheme.colors.txtSecondary,
                style = LETSSOPTTheme.typography.caption2.light12,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(8.dp),
        ) {
            items(
                items = items,
                key = { it.id }
            ) { item ->
                HomePartyItem(
                    item = item,
                )
            }
        }

    }
}

@Composable
private fun HomePartyItem(
    item: HomePartyItemModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.background(color = LETSSOPTTheme.colors.surface)
    ) {
        Box {
            Image(
                painter = painterResource(item.img),
                contentDescription = null,
                modifier = Modifier
                    .width(196.dp)
                    .aspectRatio(ASPECT_RATIO),
                contentScale = ContentScale.Crop,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_alarm),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 7.dp, end = 5.dp),
                tint = Color.Unspecified,
            )
        }

        Column(
            modifier = Modifier.padding(start = 8.dp, top = 6.dp, bottom = 7.dp)
        ) {
            Text(
                text = item.time,
                color = LETSSOPTTheme.colors.primaryRed,
                style = LETSSOPTTheme.typography.body3.medium12
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.title,
                color = LETSSOPTTheme.colors.txtPrimary,
                style = LETSSOPTTheme.typography.subhead3.semibold12,
            )
        }
    }
}

@Composable
@Preview(showBackground = false)
private fun HomePartySectionPreview() {
    LETSSOPTTheme {
        HomePartySection(
            items = persistentListOf(
                HomePartyItemModel(1, R.drawable.img_home_party_1, "오늘 21:13에 시작", "# 왕과 사는 남자"),
                HomePartyItemModel(2, R.drawable.img_home_party_2, "오늘 22:22에 시작", "# 파묘"),
            )
        )
    }
}
