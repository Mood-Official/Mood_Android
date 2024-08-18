package com.android.mood.designsystem.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object MoodTheme {
    val textColor: MoodColor
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
    textColor: MoodColor = MoodTheme.textColor,
    typography: MoodTypography = MoodTheme.typography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMoodColor provides textColor,
        LocalMoodTypography provides typography,
        content = content
    )
}