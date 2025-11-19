package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.serialization.Serializable

// 연습문제 1. Movie 클래스 작성
@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int
)