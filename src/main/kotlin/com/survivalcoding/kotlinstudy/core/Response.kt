package com.survivalcoding.kotlinstudy.core

data class Response<T>(
    val statusCode: Int,
    val header: Map<String, String>,
    val body: T,
)