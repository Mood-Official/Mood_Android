package com.android.mood.data.repository

import com.android.mood.data.mapper.toSampleImageModel
import com.android.mood.domain.model.SampleImageModel
import com.android.mood.domain.repository.SampleRepository
import com.android.mood.remote.datasource.SampleDataSource
import javax.inject.Inject

internal class SampleRepositoryImpl @Inject constructor(
    private val sampleDataSource: SampleDataSource
) : SampleRepository {
    override suspend fun getImages(): List<SampleImageModel> {
        return sampleDataSource.getImages().toSampleImageModel()
    }
}