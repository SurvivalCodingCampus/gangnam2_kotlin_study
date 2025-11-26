package com.survivalcoding.kotlinstudy.`18_result`.practice.util

sealed class NetworkError {
    object Timeout : NetworkError()
    data class ClientError(val code: Int?) : NetworkError()
    data class ServerError(val code: Int?) : NetworkError()
    data class HttpError(val code: Int?) : NetworkError()
    object ParseError: NetworkError()
    data class Unknown(val message: String) : NetworkError()
}