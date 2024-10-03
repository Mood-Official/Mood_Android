package com.android.mood.designsystem.component.datepicker.internal

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.mood.designsystem.component.text.MoodText
import com.android.mood.designsystem.foundation.MoodTheme

@Composable
internal fun BoxScope.DefaultPickerItemContent(
    text: String,
    modifier: Modifier = Modifier
) {
    MoodText(
        modifier = modifier.align(Alignment.Center),
        text = text,
        style = MoodTheme.typography.body.body1.bold,
        color = MoodTheme.color.black,
    )
}