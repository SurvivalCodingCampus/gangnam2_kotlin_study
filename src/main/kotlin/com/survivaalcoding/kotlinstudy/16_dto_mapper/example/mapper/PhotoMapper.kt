package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.mapper

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.PhotoDto
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Photo
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.PhotoType
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun PhotoDto.toModel(): Photo {
    val now = Clock.System.todayIn(TimeZone.currentSystemDefault())

    fun parseDate(value: String?): LocalDate =
        value?.takeIf { it.isNotBlank() }?.let {
            LocalDate.parse(it)
        } ?: now

    return Photo(
        id = id ?: 0,
        type = PhotoType.fromString(type),
        title = title ?: "",
        content = content ?: "",
        url = url ?: "",
        caption = caption ?: "",
        createdAt = parseDate(createdAt)
    )
}