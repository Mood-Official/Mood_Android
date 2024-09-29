package com.android.mood.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.android.mood.datastore.UserData
import com.android.mood.datastore.datastore.UserDataSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DataStoreModule {

    @Singleton
    @Provides
    fun provideUserDataStore(@ApplicationContext context: Context): DataStore<UserData> {
        return DataStoreFactory.create(
            serializer = UserDataSerializer,
            produceFile = {
                context.dataStoreFile("user_data.pb")
            }
        )
    }
}