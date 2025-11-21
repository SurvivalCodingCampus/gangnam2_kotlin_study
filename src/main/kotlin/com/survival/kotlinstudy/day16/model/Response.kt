package com.survival.kotlinstudy.day16.model

data class Response<T>(
    val codeStatus: Int,
    val header: Map<String, List<String>>,
    val body: T?
)
