package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.core

data class Response<T>(
    val headers: Map<String, List<String>>,
    val statusCode: Int,
    val body: T? = null
)
