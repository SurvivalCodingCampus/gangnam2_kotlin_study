package com.neouul.sesac.`16-result-pattern`.core

sealed class NetworkError {
    object NetworkUnavailable : NetworkError()
    object Timeout : NetworkError()
    data class HttpClientError(val code: Int) : NetworkError()
    data class HttpServerError(val code: Int) : NetworkError()
    object ParseError : NetworkError()
    data class Unknown(val message: String) : NetworkError()
}