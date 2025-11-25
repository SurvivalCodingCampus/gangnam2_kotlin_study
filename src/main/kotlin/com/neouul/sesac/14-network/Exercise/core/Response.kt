package com.neouul.sesac.`14-network`.Exercise.core

data class Response<T>(
    val statusCode: Int,
    val header: Map<String, List<String>>,
    val body: T,
)
