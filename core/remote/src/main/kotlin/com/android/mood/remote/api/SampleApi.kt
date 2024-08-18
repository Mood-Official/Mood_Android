package com.android.mood.remote.api

import com.android.mood.remote.model.sample.SampleResponse
import retrofit2.http.GET

internal interface SampleApi {
    @GET("v2/list")
    suspend fun getImages(): List<SampleResponse>
}