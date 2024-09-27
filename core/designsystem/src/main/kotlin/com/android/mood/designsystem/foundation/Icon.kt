package com.android.mood.designsystem.foundation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object MoodIcon {
    @Composable
    fun Home(
        modifier: Modifier = Modifier,
        tint: Color = Color.Unspecified,
    ) {
        Icon(
            modifier = modifier,
            imageVector = Icons.Default.Home,
            contentDescription = null,
            tint = tint,
        )
    }
}

@Composable
fun Icon24(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        iconRes = iconRes,
        size = 16.dp,
        color = color
    )
}

@Composable
fun Icon24(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = Color.Unspecified,
    onClick: () -> Unit = {},
    noRipple: Boolean = false,
) {
    Icon(
        modifier = modifier.clickable(
            onClick = onClick,
            role = Role.Image,
            enabled = enabled,
            interactionSource = remember { MutableInteractionSource() },
            indication = if (noRipple) null else rememberRipple(bounded = false, radius = 24.dp)
        ),
        iconRes = iconRes,
        size = 24.dp,
        color = color
    )
}

@Composable
internal fun Icon(
    @DrawableRes iconRes: Int,
    size: Dp,
    color: Color,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier,
        iconRes = iconRes,
        width = size,
        height = size,
        color = color
    )
}

@Composable
internal fun Icon(
    @DrawableRes iconRes: Int,
    width: Dp,
    height: Dp,
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .width(width)
            .height(height),
        painter = painterResource(id = iconRes),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        colorFilter = if (color == Color.Unspecified) null else ColorFilter.tint(color)
    )
}