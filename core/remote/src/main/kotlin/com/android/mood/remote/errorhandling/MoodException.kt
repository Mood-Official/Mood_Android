package com.android.mood.remote.errorhandling

import java.io.IOException

open class MoodException(
    val code: Int,
    override val message: String?
) : IOException(message)

fun throwMoodException(
    code: Int,
    message: String
): Nothing {
    throw MoodException(
        code = code,
        message = message
    )
}