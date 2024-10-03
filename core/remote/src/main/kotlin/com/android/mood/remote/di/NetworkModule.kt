package com.android.mood.remote.di

import com.android.mood.remote.interceptor.ErrorInterceptor
import com.android.mood.remote.interceptor.HeaderInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")
private fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            encodeDefaults = true
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(
        json: Json
    ): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            when {
                !message.isJsonObject() && !message.isJsonArray() ->
                    Timber.tag("HTTP Client").w(message)

                else -> runCatching {
                    json.encodeToString(Json.parseToJsonElement(message))
                }.onSuccess {
                    Timber.tag("HTTP Client").w(it)
                }.onFailure {
                    Timber.tag("HTTP Client").w(message)
                }
            }
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(
        moshi: Moshi
    ): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        errorInterceptor: ErrorInterceptor,
        headerInterceptor: HeaderInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(headerInterceptor)
            .addInterceptor(errorInterceptor)
            .readTimeout(TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .connectTimeout(TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    companion object {
        const val BASE_URL = "https://picsum.photos/"
        const val TIMEOUT_MILLIS = 5_000L
    }
}