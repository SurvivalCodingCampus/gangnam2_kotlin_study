package _251126_result.exercise2.core

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val body: T,
    val status: String,
    val header: String,
)