package com.android.mood.domain.repository

interface UserRepository {
    suspend fun checkDuplicatedEmail(email: String): Boolean
    suspend fun checkDuplicatedNickname(): Boolean
}