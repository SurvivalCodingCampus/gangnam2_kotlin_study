package com.neouul.sesac.core

data class Response<T>(
    val statusCode: Int,
    val header: Map<String, List<String>>,
    val body: T,
)
