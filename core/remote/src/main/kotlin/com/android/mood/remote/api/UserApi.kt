package com.android.mood.remote.api

import retrofit2.http.GET

internal interface UserApi {
    @GET("api/v1/users/email:exist")
    suspend fun checkDuplicatedEmail(): Boolean

    @GET("api/v1/users/nickname:exist")
    suspend fun checkDuplicatedNickname(): Boolean
}