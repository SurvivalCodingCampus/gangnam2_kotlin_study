package com.survivalcoding.kotlinstudy.`18_result`.practice.mapper

import com.survivalcoding.kotlinstudy.`18_result`.practice.util.NetworkError
import io.ktor.client.plugins.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.serialization.SerializationException
import java.util.concurrent.TimeoutException

fun mapNetworkError(e: Exception): NetworkError {
    return when (e) {
        is TimeoutCancellationException,
        is SocketTimeoutException,
        is TimeoutException,
        is HttpRequestTimeoutException -> NetworkError.Timeout

        is RedirectResponseException,
        is ClientRequestException,
        is ServerResponseException,
        is ResponseException -> mapStatusToHttpError(e.response.status.value)

        is SerializationException -> NetworkError.ParseError

        else -> NetworkError.Unknown("Error")
    }
}

private fun mapStatusToHttpError(statusCode: Int): NetworkError {
    return when (statusCode) {
        // 클라이언트 에러
        in 400..499 -> NetworkError.ClientError(statusCode)
        // 서버 에러
        in 500..599 -> NetworkError.ServerError(statusCode)
        else -> NetworkError.HttpError(statusCode)
    }
}