package com.ezlevup.my.day251125.exercise.mapper

import com.ezlevup.my.core.toLocalDateOrNull
import com.ezlevup.my.day251125.exercise.dto.PhotoDto
import com.ezlevup.my.day251125.exercise.model.Photo
import java.time.LocalDate

enum class PhotoType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN;

    companion object {
        fun fromString(value: String?): PhotoType {
            return when (value?.lowercase()) {
                "article" -> ARTICLE
                "image" -> IMAGE
                "video" -> VIDEO
                else -> UNKNOWN
            }
        }
    }
}

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id = this.id ?: 0,
        url = this.url ?: "",
        caption = this.caption ?: "",
        createdAt = this.createdAt.toLocalDateOrNull() ?: LocalDate.parse("1970-01-01"),
        content = this.content ?: "",
        title = this.title ?: "",
        type = PhotoType.fromString(this.type),
    )
}
