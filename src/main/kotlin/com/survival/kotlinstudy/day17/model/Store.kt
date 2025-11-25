package com.survival.kotlinstudy.day17.model

import java.time.LocalDateTime

data class Store(
    val address: String,
    val code: String,
    val createdAt: LocalDateTime,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String,
    val stockAt: LocalDateTime,
    val type: String,
)
