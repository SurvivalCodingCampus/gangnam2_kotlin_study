package com.survival.kotlinstudy.day17.mapper

import com.survival.kotlinstudy.day17.dto.StoreDto
import com.survival.kotlinstudy.day17.model.Store
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTime(time: String = "yyyy/MM/dd HH:mm:ss"): LocalDateTime? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(time)
        LocalDateTime.parse(this, formatter)
    } catch (e: Exception) {
        null
    }

}

fun StoreDto.toModel(): Store {
    return Store(
        address = addr ?: "",
        code = code ?: "",
        createdAt = createdAt?.toLocalDateTime(),
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        name = name ?: "",
        remainStat = remainStat ?: "",
        stockAt = stockAt?.toLocalDateTime(),
        type = type ?: "",
    )
}