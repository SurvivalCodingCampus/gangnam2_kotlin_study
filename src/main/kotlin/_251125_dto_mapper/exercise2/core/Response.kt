package _251125_dto_mapper.exercise2.core

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val body: T,
    val header: String = "",
    val statusCode: String
)
