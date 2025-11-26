package com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.PhotoDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Photo
import java.time.LocalDate

fun PhotoDto.toModel(): Photo {
    val safeId = id?.toIntOrNull() ?: -1 // String → Int 변환

    // createdAt: 날짜가 잘못되거나 포맷 이상할 때 null 처리
    val safeDate = try {
        createdAt?.let { LocalDate.parse(it) }
    } catch (e: Exception) {
        null
    }

    return Photo(
        id = safeId,
        type = type.toPhotoType(),
        title = title,
        content = content,
        url = url,
        caption = caption,
        createdAt = safeDate
    )
}