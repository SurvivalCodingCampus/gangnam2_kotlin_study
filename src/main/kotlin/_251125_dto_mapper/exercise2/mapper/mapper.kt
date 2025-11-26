package _251125_dto_mapper.exercise2.mapper

import _251125_dto_mapper.exercise2.dto.PhotoDto
import _251125_dto_mapper.exercise2.model.Photo
import _251125_dto_mapper.exercise2.model.PhotoType
import java.time.LocalDate

fun PhotoDto.toModel(): Photo {
    return Photo(
        caption = caption ?: "",
        content = content ?: "",
        createdAt = (createdAt ?: "").toLocalDate(),
        id = id ?: 0,
        title = title ?: "",
        type = (type ?: "").toPhotoType(),
        url = url ?: ""
    )
}

fun String.toLocalDate(): LocalDate {
    return if (this.isEmpty()) {
        LocalDate.of(2025, 11, 25)

    } else {
        LocalDate.of(this.substring(0, 4).toInt(), this.substring(5, 7).toInt(), this.substring(8, 10).toInt())
    }
}

fun String.toPhotoType(): Enum<PhotoType> {
    return when (this.lowercase()) {
        "Article".lowercase() -> {
            PhotoType.ARTICLE
        }

        "Image".lowercase() -> {
            PhotoType.IMAGE
        }

        "Video".lowercase() -> {
            PhotoType.VIDEO
        }

        else -> {
            PhotoType.UNKNOWN
        }
    }


}