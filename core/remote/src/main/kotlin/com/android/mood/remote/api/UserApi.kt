package com.android.mood.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

internal interface UserApi {
    @GET("api/v1/users/check")
    suspend fun checkDuplicatedEmail(@Query("email") email: String): Boolean

    @GET("api/v1/users/nickname:exist")
    suspend fun checkDuplicatedNickname(): Boolean
}