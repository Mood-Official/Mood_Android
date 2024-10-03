package com.android.mood.remote.di

import com.android.mood.remote.datasource.SampleDataSource
import com.android.mood.remote.datasource.UserRemoteDataSource
import com.android.mood.remote.datasource.impl.SampleDataSourceImpl
import com.android.mood.remote.datasource.impl.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Binds
    @Singleton
    fun bindSampleDataSource(impl: SampleDataSourceImpl): SampleDataSource

    @Binds
    @Singleton
    fun bindUserDataSource(impl: UserDataSourceImpl): UserRemoteDataSource
}