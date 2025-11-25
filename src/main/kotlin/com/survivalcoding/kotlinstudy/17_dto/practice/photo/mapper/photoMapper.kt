package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.mapper

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.dto.PhotoDto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.Photo
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.PhotoType
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id = id ?: 0,
        type = when (type?.lowercase()) {
            "article" -> PhotoType.Article
            "image"   -> PhotoType.Image
            "video"   -> PhotoType.Video
            else      -> PhotoType.Unknown
        },
        url = url ?: "",
        title = title ?: "",
        caption = caption ?: "",
        content = content ?: "",
        createdAt = if (created_at.isNullOrBlank()) {
            LocalDate(1000, 1, 1)
        } else {
            val replaced = created_at
                .replace("/", "-")

            LocalDate.parse(replaced)
        }
    )
}