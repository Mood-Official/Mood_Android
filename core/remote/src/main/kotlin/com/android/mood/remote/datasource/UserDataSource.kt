package com.android.mood.remote.datasource

interface UserDataSource {
    suspend fun checkDuplicatedEmail(deviceId: String): Boolean
    suspend fun checkDuplicatedNickname(): Boolean
}