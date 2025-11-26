package com.sesac.practice.day17.core

data class Response<T>(
    val statusCode: Int,
    val headers: Map<String, List<String>>,
    val body: T? = null,
)
