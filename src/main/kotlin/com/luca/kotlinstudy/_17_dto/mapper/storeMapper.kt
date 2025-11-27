package com.luca.kotlinstudy._17_dto.mapper

import com.luca.kotlinstudy._17_dto.dto.StoreDTO
import com.luca.kotlinstudy._17_dto.model.Store
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private val STOCK_AT_FORMATTER: DateTimeFormatter =
    DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

fun String.toLocalDateTimeOrNull(): LocalDateTime? =
    try {
        LocalDateTime.parse(this, STOCK_AT_FORMATTER)
    } catch (e: DateTimeParseException) {
        null
    }

fun StoreDTO.toModel(): Store = Store(
    name = name ?: "",
    address = addr ?: "",
    stockStatus = remainStat ?: "",
    latitude = lat ?: 0.0,
    longitude = lng ?: 0.0,
    lastStockedAt = stockAt?.toLocalDateTimeOrNull(),
)