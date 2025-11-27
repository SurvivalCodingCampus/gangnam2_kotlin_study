package com.luca.kotlinstudy._17_dto.model

import java.time.LocalDateTime

data class Store(
    val name: String,
    val address: String,
    val stockStatus: String,
    val latitude: Double,
    val longitude: Double,
    val lastStockedAt: LocalDateTime?,
)
