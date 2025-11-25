package com.survival.kotlinstudy.day17.mapper

import com.survival.kotlinstudy.day17.dto.PhotoDto
import com.survival.kotlinstudy.day17.model.Photo
import com.survival.kotlinstudy.day17.model.PhotoType
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun PhotoDto.toModel(): Photo {
    return Photo(
        id = id ?: 0,
        type = when (type) {
            "article" -> PhotoType.ARTICLE
            "image" -> PhotoType.IMAGE
            "video" -> PhotoType.VIDEO
            else -> PhotoType.UNKNOWN
        },
        title = title ?: "",
        url = url ?: "",
        content = content ?: "",
        caption = caption ?: "",
        createdAt = createdAt?.toLocalDate(),
    )
}


fun String.toLocalDate(pattern: String = "yyyy-MM-dd"): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        LocalDate.parse(this, formatter)
    } catch (e: DateTimeParseException) {
        null
    }
}