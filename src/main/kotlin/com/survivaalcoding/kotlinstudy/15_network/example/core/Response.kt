package com.survivaalcoding.kotlinstudy.`15_network`.example.core

data class Response<T>(
    val headers: Map<String, List<String>>,
    val statusCode: Int,
    val body: T
)