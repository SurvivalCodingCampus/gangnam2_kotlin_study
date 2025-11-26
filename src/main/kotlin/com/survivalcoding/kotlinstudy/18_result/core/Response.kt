package com.survivalcoding.kotlinstudy.`18_result`.core

data class Response<T>(
    val statusCode: Int,
    val headers: Map<String, List<String>>,
    val body: T?,
)