package com.android.mood.core.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.android.mood.core.local.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface MemoDao : BaseDao<MemoEntity> {
    @Query("SELECT * FROM memos")
    fun getMemos(): Flow<List<MemoEntity>>
}