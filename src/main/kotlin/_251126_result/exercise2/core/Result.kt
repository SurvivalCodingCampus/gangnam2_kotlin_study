package _251126_result.exercise2.core

import kotlinx.serialization.Serializable

@Serializable
sealed class Result<out T, out E> {
    data class Success<out T>(
        val data: T
    ) : Result<T, Nothing>()

    data class Error<out E>(
        val error: E
    ) : Result<Nothing, E>()
}

@Serializable
sealed class NetworkError {
    object NetWorkUnavailable : NetworkError()
    object TimeOut : NetworkError()
    data class HttpError(val code: Int) : NetworkError()
    object ParseError : NetworkError()
    data class Unknown(val message: String) : NetworkError()
}