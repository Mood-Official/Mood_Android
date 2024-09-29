package com.android.mood.remote.errorhandling

import com.android.mood.remote.errorhandling.MoodNetworkException.Companion.INTERNAL_SERVER_ERROR_CODE
import com.android.mood.remote.errorhandling.MoodNetworkException.Companion.INTERNAL_SERVER_ERROR_MESSAGE
import com.android.mood.remote.errorhandling.MoodNetworkException.Companion.UNKNOWN_ERROR
import com.android.mood.remote.errorhandling.MoodNetworkException.Companion.UNKNOWN_ERROR_MESSAGE
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MoodNetworkException(
    code: Int,
    override val message: String?,
) : MoodException(code, message) {
    companion object {
        const val INTERNAL_SERVER_ERROR_CODE = 500
        const val INTERNAL_SERVER_ERROR_MESSAGE = "네트워크 연결을 확인할 수 없습니다. 잠시 후 다시 시도해주세요."

        const val UNKNOWN_ERROR = -9999
        const val UNKNOWN_ERROR_MESSAGE = "알수 없는 에러가 발생하였습니다."
    }
}

fun Exception.parseWithNetworkError(): MoodNetworkException {
    return when (this) {
        is UnknownHostException, is SocketException, is SocketTimeoutException -> {
            MoodNetworkException(
                code = INTERNAL_SERVER_ERROR_CODE,
                message = INTERNAL_SERVER_ERROR_MESSAGE,
            )
        }

        else -> {
            MoodNetworkException(
                code = UNKNOWN_ERROR,
                message = UNKNOWN_ERROR_MESSAGE,
            )
        }
    }
}