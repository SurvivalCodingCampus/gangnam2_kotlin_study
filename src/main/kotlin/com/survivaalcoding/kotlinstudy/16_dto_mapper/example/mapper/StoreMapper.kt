package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.mapper

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.StoreDto
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Store
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toKotlinLocalDateTime
import kotlinx.datetime.toLocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun StoreDto.toModel(): Store {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

    fun parseDate(value: String?): LocalDateTime =
        value?.takeIf { it.isNotBlank() }?.let {
            java.time.LocalDateTime.parse(it, formatter).toKotlinLocalDateTime()
        } ?: now

    return Store(
        code = code ?: "",
        name = name ?: "",
        address = address ?: "",
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        remainStat = remainStat ?: "",
        stockAt = parseDate(stockAt),
        createdAt = parseDate(createdAt)
    )
}
