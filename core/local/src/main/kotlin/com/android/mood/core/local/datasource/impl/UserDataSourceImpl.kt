package com.android.mood.core.local.datasource.impl

import androidx.datastore.core.DataStore
import com.android.mood.core.local.datasource.UserDataSource
import com.android.mood.core.local.entity.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val userDataStore: DataStore<UserData>,
) : UserDataSource {
    override val userDataFlow: Flow<UserData> = userDataStore.data

    override suspend fun setUser(user: UserData) {
        userDataStore.updateData { user }
    }
}