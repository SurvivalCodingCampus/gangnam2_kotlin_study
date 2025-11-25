package com.sesac.practice.day16.mapper

import com.sesac.practice.day16.dto.StoreDto
import com.sesac.practice.day16.model.Store
import java.time.DateTimeException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun StoreDto.toModel(): Store = Store(
    address = addr ?: "주소 없음",
    createdAt = parseDateTime(createdAt),
    latitude = lat,
    longitude = lng,
    name = name ?: "이름 없음",
    remainStatus = remainStat ?: "",
    stockAt = parseDateTime(stockAt),
    type = type ?: "",
)

private val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

private fun parseDateTime(dateTime: String?): LocalDateTime? = dateTime?.let {
    try {
        LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER)
    } catch (_: DateTimeException) {
        null
    }
}
