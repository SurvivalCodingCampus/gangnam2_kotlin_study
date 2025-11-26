package com.survival.kotlinstudy.day18.core

data class Response<T>(
    val codeStatus: Int,
    val header: Map<String, List<String>>,
    val body: T?
)