package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.mapper

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model.Store
import kotlinx.datetime.LocalDateTime

fun StoreDto.toStore(): Store {
    return Store(
        address = addr ?: "",
        code = code?.toIntOrNull() ?: 0,
        createdAt = if (created_at.isNullOrBlank()) {
            LocalDateTime(0, 1, 1, 0, 0, 0)
        } else {
            val replaced = created_at
                .replace("/", "-")
                .replace(" ", "T")

            LocalDateTime.parse(replaced)
        },
        latitude = lat ?: 0.0,
        longitude = lng ?: 0.0,
        name = name ?: "",
        remainStat = remain_stat ?: "",
        stockAt = if (stock_at.isNullOrBlank()) {
            LocalDateTime(0, 1, 1, 0, 0, 0)
        } else {
            val replaced = stock_at
                .replace("/", "-")
                .replace(" ", "T")

            LocalDateTime.parse(replaced)
        },
        type = type ?: ""
    )
}
