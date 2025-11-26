package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.mapper

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model.Store
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val FORMATTER: DateTimeFormatter =
    DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

fun StoreDto.toStore(): Store {
    return Store(
        address = addr ?: "",
        code = code?.toIntOrNull() ?: 0,
        createdAt = if (created_at.isNullOrBlank()) {
            LocalDateTime.of(1000, 1, 1, 0, 0, 0)
        } else {
            LocalDateTime.parse(created_at, FORMATTER)
        },
        latitude = lat ?: 0.0,
        longitude = lng ?: 0.0,
        name = name ?: "",
        remainStat = remain_stat ?: "",
        stockAt = if (stock_at.isNullOrBlank()) {
            LocalDateTime.of(1000, 1, 1, 0, 0, 0)
        } else {
            LocalDateTime.parse(stock_at, FORMATTER)
        },
        type = type ?: ""
    )
}
