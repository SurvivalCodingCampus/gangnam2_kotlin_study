package _251126_result.exercise2.core

import io.ktor.http.*

data class Response<T>(
    val body: T,
    val status: HttpStatusCode,
    val header: String,
)