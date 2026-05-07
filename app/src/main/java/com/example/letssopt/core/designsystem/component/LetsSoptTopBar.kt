package com.example.letssopt.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.extension.noRippleClickable

@Composable
fun LetsSoptTopBar(
    navigateToProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 23.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_camera),
            contentDescription = null,
            tint = LETSSOPTTheme.colors.txtPrimary,
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_noti),
            contentDescription = null,
            tint = LETSSOPTTheme.colors.txtPrimary,
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onClick = navigateToProfile),
            tint = LETSSOPTTheme.colors.txtPrimary,
        )
    }
}

@Preview
@Composable
private fun LetsSoptTopBarPreview(){
    LETSSOPTTheme{
        LetsSoptTopBar(
            navigateToProfile = {}
        )
    }
}
