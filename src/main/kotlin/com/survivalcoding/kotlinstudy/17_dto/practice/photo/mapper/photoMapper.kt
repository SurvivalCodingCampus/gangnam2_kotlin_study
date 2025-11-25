package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.mapper

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.dto.PhotoDto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.Photo
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.PhotoType
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val FORMATTER: DateTimeFormatter =
    DateTimeFormatter.ofPattern("yyyy/MM/dd")

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id = id ?: 0,
        type = when (type?.lowercase()) {
            "article" -> PhotoType.Article
            "image" -> PhotoType.Image
            "video" -> PhotoType.Video
            else -> PhotoType.Unknown
        },
        url = url ?: "",
        title = title ?: "",
        caption = caption ?: "",
        content = content ?: "",
        createdAt = if (created_at.isNullOrBlank()) {
            LocalDate.of(1000, 1, 1)
        } else {
            LocalDate.parse(created_at, FORMATTER)
        }
    )
}
