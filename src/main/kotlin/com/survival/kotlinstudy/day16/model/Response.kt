package com.survival.kotlinstudy.day16.model

data class Response<T>(
    val codeStatus: Int,
    val header: Map<String, String>,
    val body: T?
)
