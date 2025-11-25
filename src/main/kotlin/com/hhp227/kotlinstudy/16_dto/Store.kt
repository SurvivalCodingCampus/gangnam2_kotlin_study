package com.hhp227.kotlinstudy.`16_dto`

data class Store(
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val remainStat: String,
    val stockAt: String
)