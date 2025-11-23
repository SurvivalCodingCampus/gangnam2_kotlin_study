package com.survivalcoding.kotlinstudy.`16_network`.core

data class Response<T>(
    val statusCode: Int,
    val headers: Map<String, List<String>>,
    val body: T?,
)