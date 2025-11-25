package com.luca.kotlinstudy._16_http.core

data class Response<T>(
    val statusCode: Int,
    val headers: Map<String, List<String>>,
    val body: T?
)
