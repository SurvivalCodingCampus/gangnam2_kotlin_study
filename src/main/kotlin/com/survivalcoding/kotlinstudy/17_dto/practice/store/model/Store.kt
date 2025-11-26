package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model

import java.time.LocalDateTime

data class Store (
    val address: String,
    val code: Int,
    val createdAt: LocalDateTime,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val remainStat: String,
    val stockAt: LocalDateTime,
    val type: String
)