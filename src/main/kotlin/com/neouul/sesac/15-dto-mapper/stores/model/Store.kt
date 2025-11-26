package com.neouul.sesac.`15-dto-mapper`.stores.model

import java.time.LocalDateTime

data class Store(
    val address: String,
    val code: String,
    val createdAt: LocalDateTime,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val remainStat: String,     // plenty(178), some(13), few(4), break(15), empty(6) | null(5), 필드없음(1)
    val stockAt: LocalDateTime,
    // type은 전부 01 이라서 제외
)