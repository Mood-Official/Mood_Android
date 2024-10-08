package com.android.mood.designsystem.component.actionbar.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.component.actionbar.ACTION_BAR_HEIGHT

@Composable
internal fun CoreActionBarLayout(
    backgroundBrush: Brush,
    modifier: Modifier = Modifier,
    mainContent: @Composable RowScope.() -> Unit,
    menuContent: @Composable (RowScope.() -> Unit)?,
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(ACTION_BAR_HEIGHT)
                .background(brush = backgroundBrush)
                .padding(start = 16.dp, end = 20.dp),
            horizontalArrangement = if (menuContent != null) {
                Arrangement.spacedBy(20.dp)
            } else {
                Arrangement.Start
            },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                content = mainContent,
            )
            if (menuContent != null) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    content = menuContent,
                )
            }
        }
    }
}