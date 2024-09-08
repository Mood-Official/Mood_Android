package com.android.mood.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object MoodTheme {
    val color: MoodColor
        @Composable
        @ReadOnlyComposable
        get() = LocalMoodColor.current

    val typography: MoodTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMoodTypography.current
}

@Composable
fun MoodTheme(
    color: MoodColor = MoodTheme.color,
    typography: MoodTypography = MoodTheme.typography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMoodColor provides color,
        LocalMoodTypography provides typography,
        content = content
    )
}