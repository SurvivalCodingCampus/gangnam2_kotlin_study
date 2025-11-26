package com.survivaalcoding.kotlinstudy.`17_result`.example.core

data class Response<T>(
    val headers: Map<String, List<String>>,
    val statusCode: Int,
    val body: T? = null
)
