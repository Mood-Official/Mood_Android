package com.android.mood.designsystem.component.datepicker.internal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.mood.designsystem.foundation.MoodTheme

@Composable
internal fun BoxScope.DefaultPickerDecoration(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .align(Alignment.Center)
            .fillMaxWidth()
            .height(26.dp)
            .background(MoodTheme.color.gray50)
    )
}