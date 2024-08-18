package com.android.mood.domain.repository

import com.android.mood.domain.model.SampleImageModel

interface SampleRepository {
    suspend fun getImages(): List<SampleImageModel>
}