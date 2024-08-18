package com.android.mood.remote.datasource

import com.android.mood.remote.model.sample.SampleResponse

interface SampleDataSource {
    suspend fun getImages(): List<SampleResponse>
}