package com.android.mood.designsystem.component.tabbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.extension.boxShadow
import com.android.mood.designsystem.foundation.MoodRadius
import com.android.mood.designsystem.foundation.MoodTheme

@Composable
fun MoodNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TabBar(
        modifier = modifier,
        windowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom),
        content = content
    )
}

internal val TabBarHeight = 64.dp

@Composable
fun TabBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MoodTheme.textColor.white,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom),
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .background(color = Color(0XFFFCFCFC), shape = MoodRadius.Radius30.shape)
            .boxShadow(
                color = Color(0X0D000000),  // TODO(JaesungLeee) : 컬러 재정의 필요
                blurRadius = 20.dp,
                offset = DpOffset(x = 0.dp, y = (-4).dp)
            )
            .clip(MoodRadius.RadiusTop30.shape),
        color = backgroundColor,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .defaultMinSize(minHeight = TabBarHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}


@Preview
@Composable
private fun MoodTabBarPreview() {
    Scaffold(
        bottomBar = {
            TabBar() {}
        },
        scaffoldState = rememberScaffoldState(),
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

            }
        }
    )
}
