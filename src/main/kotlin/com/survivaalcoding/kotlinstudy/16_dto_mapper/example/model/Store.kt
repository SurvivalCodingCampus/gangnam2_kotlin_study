package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model

import kotlinx.datetime.LocalDateTime

data class Store(
    val code: String,
    val name: String,
    val address: String,
    val lat: Double,
    val lng: Double,
    val remainStat: String,
    val stockAt: LocalDateTime,
    val createdAt: LocalDateTime
)
