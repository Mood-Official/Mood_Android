package com.android.mood.feature.sample.mvi

import com.android.mood.common.android.base.UiState
import com.android.mood.domain.model.SampleImageModel

data class SampleState(
    val isLoading: Boolean = false,
    val images: List<SampleImageModel> = emptyList(),
) : UiState