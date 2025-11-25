package com.survival.kotlinstudy.day17.mapper

import com.survival.kotlinstudy.day17.dto.StoreDto
import com.survival.kotlinstudy.day17.model.Store
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTime(time: String = "yyyy/MM/dd HH:mm:ss"): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern(time)
    return LocalDateTime.parse(this, formatter)
}

fun StoreDto.toModel(): Store {
    return Store(
        address = addr ?: "",
        code = code ?: "",
        createdAt = createdAt?.toLocalDateTime() ?: LocalDateTime.now(),
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        name = name ?: "",
        remainStat = remainStat ?: "",
        stockAt = stockAt?.toLocalDateTime() ?: LocalDateTime.now(),
        type = type ?: "",
    )
}