package com.android.mood.feature.sample.mvi

import com.android.mood.common.android.base.UiIntent

sealed class SampleIntent : UiIntent {
    data object ClickGetImagesButton : SampleIntent()
}