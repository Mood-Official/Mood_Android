package com.android.mood.core.local.datasource

import com.android.mood.core.local.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

interface MemoDataSource {
    fun getMemes(): Flow<List<MemoEntity>>
}