package _251121_ktor.exercise1to3.model

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val body: T,
    val statusCode: String,
)