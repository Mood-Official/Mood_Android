package com.android.mood.designsystem.component.actionbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.mood.core.designsystem.R
import com.android.mood.designsystem.component.actionbar.internal.CoreActionBarLayout
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.foundation.Icon24
import com.android.mood.designsystem.foundation.MoodTheme

val ACTION_BAR_HEIGHT = 56.dp

@Composable
fun ActionBar(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = "",
    backgroundColor: Color = MoodTheme.color.white,
    titleColor: Color = MoodTheme.color.black,
    backButtonColor: Color = MoodTheme.color.black,
    menuContent: @Composable (() -> Unit)? = null,
) {
    CoreActionBarLayout(
        modifier = modifier,
        backgroundBrush = SolidColor(backgroundColor),
        mainContent = {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon24(
                    iconRes = R.drawable.ic_arrow_left_thickness_1_5,
                    color = backButtonColor,

                    )
                MoodText(
                    text = title,
                    style = MoodTheme.typography.subtitle.subtitle3.bold,
                    color = titleColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        menuContent = if (menuContent != null) {
            { menuContent() }
        } else {
            null
        },
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun ActionBarPreview1() {
    ActionBar(
        onBack = {},
        title = "Preview"
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun ActionBarPreview2() {
    ActionBar(
        onBack = {},
        title = "Preview",
        menuContent = {
            Icon24(
                onClick = {},
                iconRes = R.drawable.ic_plus,
            )
            Icon24(
                onClick = {},
                iconRes = R.drawable.ic_check_thickness_2_0,
            )
        }
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun ActionBarPreview3() {
    ActionBar(
        onBack = {},
        title = "Preview Preview Preview Preview",
        menuContent = {
            Icon24(
                onClick = {},
                iconRes = R.drawable.ic_plus,
            )
            Icon24(
                onClick = {},
                iconRes = R.drawable.ic_check_thickness_2_0,
            )
            Icon24(
                onClick = {},
                iconRes = R.drawable.ic_minus_thickness_2_0,
            )
        }
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun ActionBarPreview4() {
    ActionBar(
        onBack = {},
        title = "Preview",
        backgroundColor = MoodTheme.color.primary500,
        titleColor = MoodTheme.color.black,
        backButtonColor = MoodTheme.color.black,
    )
}