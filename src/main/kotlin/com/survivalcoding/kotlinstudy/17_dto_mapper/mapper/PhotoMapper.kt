package com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.PhotoDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Photo
import java.time.LocalDate

fun PhotoDto.toModel(): Photo {
    return Photo(
        id = id,
        type = type.toPhotoType(),
        title = title,
        content = content,
        url = url,
        caption = caption,
        createdAt = createdAt?.let { LocalDate.parse(it) }
    )
}