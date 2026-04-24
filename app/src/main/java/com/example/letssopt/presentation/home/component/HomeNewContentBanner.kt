package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlin.math.absoluteValue

private const val ASPECT_RATIO = 7/4f

@Composable
fun HomeNewContentBanner(
    newContentItems: ImmutableList<Int>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "방금 막 도착한 신상 컨텐츠",
            modifier = Modifier.padding(horizontal = 19.dp),
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.h3.semibold20,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "예능부터 드라마까지!",
            modifier = Modifier.padding(horizontal = 19.dp),
            color = LETSSOPTTheme.colors.txtTertiary,
            style = LETSSOPTTheme.typography.subhead2.semibold18,
        )

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 40.dp),
            pageSpacing = 12.dp,
        ) { page ->
            NewContentCard(
                item = newContentItems[page % newContentItems.size],
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                        alpha = lerp(
                            start = 0.2f,
                            stop = 1f,
                            fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
                        )
                    },
            )
        }
    }
}

@Composable
private fun NewContentCard(
    item: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(item),
        contentDescription = null,
        modifier = modifier
            .width(280.dp)
            .aspectRatio(ASPECT_RATIO)
            .clip(RoundedCornerShape(10.dp)),
        contentScale = ContentScale.Crop,
    )
}


@Composable
@Preview(showBackground = true)
private fun SlideCardPreview() {
    LETSSOPTTheme {
        val pagerState = rememberPagerState(pageCount = { 3 })
        HomeNewContentBanner(
            newContentItems = persistentListOf(
                R.drawable.img_home_newcontent_1,
                R.drawable.img_home_newcontent_2,
                R.drawable.img_home_newcontent_3,
            ),
            pagerState = pagerState,
        )
    }
}
