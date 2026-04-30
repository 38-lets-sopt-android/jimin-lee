package com.example.letssopt.presentation.storage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.extension.noRippleClickable
import com.example.letssopt.data.local.entity.StorageEntity

private const val ASPECT_RATIO = 2/3f

@Composable
fun StorageItem(
    item: StorageEntity,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(item.img),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .aspectRatio(ASPECT_RATIO)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_delete),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onClick = onDeleteClick),
            tint = Color.Unspecified,
        )
    }
}

@Preview
@Composable
private fun StorageItemPreview() {
    LETSSOPTTheme {
        StorageItem(
            item = StorageEntity(1, "", R.drawable.img_home_1),
            onDeleteClick = {},
        )
    }
}
