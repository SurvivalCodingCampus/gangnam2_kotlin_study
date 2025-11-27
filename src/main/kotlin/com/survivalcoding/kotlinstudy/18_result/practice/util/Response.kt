package com.survivalcoding.kotlinstudy.`18_result`.practice.util

data class Response<T>(
    val statusCode: Int,
    val header: Map<String, List<String>>,
    val body: T,
)