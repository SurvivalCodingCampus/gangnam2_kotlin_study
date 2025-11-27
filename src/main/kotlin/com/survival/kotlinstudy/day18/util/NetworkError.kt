package com.survival.kotlinstudy.day18.util

sealed class NetworkError {
    object NetworkUnavailable : NetworkError()
    object Timeout : NetworkError()
    data class HttpError(val code: Int) : NetworkError()
    object ParseError : NetworkError()
    data class Unknown(val message: String) : NetworkError()
    data class ClientError(val code: Int) : NetworkError()
    data class ServerError(val code: Int) : NetworkError()
}