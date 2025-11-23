package _251121_ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val body: T,
    val statusCode: String,
)