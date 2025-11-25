package _251125_dto_mapper.exercise1.core

import io.ktor.http.*

data class Response<T>(
    val body: T,
    val header: String = "",
    val statusCode: HttpStatusCode
)
