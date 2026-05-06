package com.example.letssopt.presentation.purchase.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.letssopt.data.model.StorageItemModel

private const val ASPECT_RATIO = 2/3f

@Composable
fun PurchaseItem(
    item: StorageItemModel,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box {
            Image(
                painter = painterResource(item.img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ASPECT_RATIO)
                    .clip(RoundedCornerShape(10.dp))
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_save),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable(onClick = onSaveClick)
                    .align(Alignment.TopEnd)
                    .padding(top = 6.dp, end = 6.dp),
                tint = Color.Unspecified,
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = item.title,
            modifier = Modifier.align(Alignment.Start),
            color = LETSSOPTTheme.colors.txtPrimary,
            style = LETSSOPTTheme.typography.body.regular16,
        )
    }
}

@Preview
@Composable
private fun PurchaseItemPreview() {
    LETSSOPTTheme {
        PurchaseItem(
            item = StorageItemModel(1L, "이 사랑 통역 되나요", R.drawable.img_home_1),
            onSaveClick = {},
        )
    }
}
