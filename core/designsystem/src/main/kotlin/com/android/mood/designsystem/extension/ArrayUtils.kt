package com.android.mood.designsystem.extension

import androidx.compose.runtime.Stable

@Stable
internal fun BooleanArray.countTrue(): Int = count { it }