package com.android.mood.core.local.di

import android.content.Context
import androidx.room.Room
import com.android.mood.core.local.database.MemoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MemoDatabase =
        Room.databaseBuilder(
            context = context,
            klass = MemoDatabase::class.java,
            name = MemoDatabase.DATABASE_NAME
        ).build()
}