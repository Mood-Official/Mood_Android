package com.android.mood.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.mood.core.local.dao.MemoDao
import com.android.mood.core.local.entity.MemoEntity

@Database(
    entities = [MemoEntity::class],
    version = 1,
    exportSchema = false, // TODO() : 추후 true 처리
)
internal abstract class MemoDatabase : RoomDatabase() {

    abstract fun memeDao(): MemoDao

    companion object {
        const val DATABASE_NAME = "memo-database"
    }

}