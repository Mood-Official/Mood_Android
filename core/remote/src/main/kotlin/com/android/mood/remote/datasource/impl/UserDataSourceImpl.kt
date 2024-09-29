package com.android.mood.remote.datasource.impl

import com.android.mood.remote.api.UserApi
import com.android.mood.remote.datasource.UserRemoteDataSource
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    private val userApi: UserApi,
) : UserRemoteDataSource {
    override suspend fun checkDuplicatedEmail(email: String): Boolean {
        return userApi.checkDuplicatedEmail(email)
    }

    override suspend fun checkDuplicatedNickname(): Boolean {
        return userApi.checkDuplicatedNickname()
    }
}