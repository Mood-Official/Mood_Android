package com.android.mood.remote.datasource.impl

import com.android.mood.remote.api.SampleApi
import com.android.mood.remote.datasource.SampleDataSource
import com.android.mood.remote.model.sample.SampleResponse
import javax.inject.Inject


internal class SampleDataSourceImpl @Inject constructor(
    private val sampleApi: SampleApi,
) : SampleDataSource {
    override suspend fun getImages(): List<SampleResponse> {
        return sampleApi.getImages()
    }
}