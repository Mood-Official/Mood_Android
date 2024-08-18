package com.android.mood.core.local.datasource.impl

import com.android.mood.core.local.dao.MemoDao
import com.android.mood.core.local.datasource.MemoDataSource
import com.android.mood.core.local.entity.MemoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MemoDataSourceImpl @Inject constructor(
    private val memeDao: MemoDao
) : MemoDataSource {
    override fun getMemes(): Flow<List<MemoEntity>> {
        return memeDao.getMemos()
    }
}