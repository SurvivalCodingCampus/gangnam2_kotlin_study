package com.sesac.practice.day16.model

import java.time.LocalDateTime

data class Store(
    val address: String,
    val createdAt: LocalDateTime?,
    val latitude: Double?,
    val longitude: Double?,
    val name: String,
    val remainStatus: String,
    val stockAt: LocalDateTime?,
    val type: String,
)
