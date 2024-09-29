package com.android.mood.remote.datasource.impl

import com.android.mood.remote.api.UserApi
import com.android.mood.remote.datasource.UserDataSource
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi,
) : UserDataSource {
    override suspend fun checkDuplicatedEmail(deviceId: String): Boolean {
        return userApi.checkDuplicatedEmail()
    }

    override suspend fun checkDuplicatedNickname(): Boolean {
        return userApi.checkDuplicatedNickname()
    }
}