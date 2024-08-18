package com.android.mood.data.mapper

import com.android.mood.domain.model.SampleImageModel
import com.android.mood.remote.model.sample.SampleResponse


internal fun List<SampleResponse>.toSampleImageModel(): List<SampleImageModel> {
    return this.map { sampleResponse ->
        SampleImageModel(sampleResponse.download_url, sampleResponse.author)
    }
}