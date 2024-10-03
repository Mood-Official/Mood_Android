package com.android.mood.remote.interceptor

import com.android.mood.remote.errorhandling.MoodException
import com.android.mood.remote.errorhandling.parseWithNetworkError
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

class ErrorInterceptor @Inject constructor(
    private val json: Json,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            val responseBody = response.body
            if (responseBody != null && response.isSuccessful) {
                return response
            }
            responseBody?.let { body ->
                val json = JSONObject(body.string())
                throw MoodException(
                    code = json["resultCode"].toString().toInt(),
                    message = json["message"].toString(),
                )
            }
            return response
        } catch (e: Exception) {
            Timber.e("error interceptor $e")
            throw e.parseWithNetworkError()
        }
    }
}