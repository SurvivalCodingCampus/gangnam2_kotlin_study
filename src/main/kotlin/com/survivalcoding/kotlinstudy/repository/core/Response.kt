package com.survivalcoding.kotlinstudy.repository.core

data class Response<T>(
    val statusCode: Int,
    val header: Map<String, String>,
    val body: T,
)