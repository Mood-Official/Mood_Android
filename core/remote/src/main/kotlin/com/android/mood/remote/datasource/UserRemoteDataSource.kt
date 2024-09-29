package com.android.mood.remote.datasource

interface UserRemoteDataSource {
    suspend fun checkDuplicatedEmail(email: String): Boolean
    suspend fun checkDuplicatedNickname(): Boolean
}