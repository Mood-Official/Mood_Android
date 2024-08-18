package com.android.mood.core.local.di

import com.android.mood.core.local.datasource.MemoDataSource
import com.android.mood.core.local.datasource.impl.MemoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsMemeDataSource(dataSource: MemoDataSourceImpl): MemoDataSource
}