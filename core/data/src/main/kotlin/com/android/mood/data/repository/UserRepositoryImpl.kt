package com.android.mood.data.repository

import com.android.mood.domain.repository.UserRepository
import com.android.mood.remote.datasource.UserRemoteDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun checkDuplicatedEmail(email: String): Boolean {
        return userRemoteDataSource.checkDuplicatedEmail(email)
    }

    override suspend fun checkDuplicatedNickname(): Boolean {
        TODO("Not yet implemented")
    }
}