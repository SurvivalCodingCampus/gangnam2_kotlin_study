package com.survivalcoding.kotlinstudy.repository.core

import kotlinx.serialization.Serializable

@Serializable
data class Response<T>(
    val statusCode: Int? = null,
    val header: Map<String, List<String>>? = null,
    val body: T,
)