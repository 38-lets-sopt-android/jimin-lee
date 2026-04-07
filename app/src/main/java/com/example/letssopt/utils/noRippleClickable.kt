package com.example.letssopt.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit,
    enabled: Boolean = true,
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource()},
        enabled = enabled,
    ) {
        onClick()
    }
}
