package com.android.mood.domain.usecase

import com.android.mood.domain.model.SampleImageModel
import com.android.mood.domain.repository.SampleRepository
import javax.inject.Inject

interface SampleUseCase {
    suspend fun getImages(): List<SampleImageModel>
}

internal class SampleUseCaseImpl @Inject constructor(
    private val sampleRepository: SampleRepository
) : SampleUseCase {
    override suspend fun getImages(): List<SampleImageModel> {
        return sampleRepository.getImages()
    }
}