package com.android.mood.feature.sample

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.android.mood.common.android.base.BaseViewModel
import com.android.mood.domain.usecase.SampleUseCase
import com.android.mood.feature.sample.mvi.SampleIntent
import com.android.mood.feature.sample.mvi.SampleSideEffect
import com.android.mood.feature.sample.mvi.SampleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val sampleUseCase: SampleUseCase,
) : BaseViewModel<SampleState, SampleSideEffect, SampleIntent>(savedStateHandle) {
    override suspend fun handleIntent(intent: SampleIntent) {
        when (intent) {
            is SampleIntent.ClickGetImagesButton -> getImages()
        }
    }

    private fun updateLoading(isLoading: Boolean) {
        reduce {
            copy(isLoading = isLoading)
        }
    }

    private fun getImages() {
        viewModelScope.launch {
            updateLoading(true)
            val images = sampleUseCase.getImages()
            reduce {
                copy(images = images)
            }
            updateLoading(false)
        }
    }

    override fun createInitialState(savedStateHandle: SavedStateHandle): SampleState {
        return SampleState()
    }

    override fun handleClientException(throwable: Throwable) {
    }
}