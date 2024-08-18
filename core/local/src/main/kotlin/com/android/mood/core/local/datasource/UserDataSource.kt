package com.android.mood.core.local.datasource

import com.android.mood.core.local.entity.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    val userDataFlow: Flow<UserData>
    suspend fun setUser(user: UserData)
}