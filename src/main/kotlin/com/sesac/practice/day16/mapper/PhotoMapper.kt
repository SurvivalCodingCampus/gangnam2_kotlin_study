package com.sesac.practice.day16.mapper

import com.sesac.practice.day16.core.toLocalDate
import com.sesac.practice.day16.core.toPhotoType
import com.sesac.practice.day16.dto.PhotoDto
import com.sesac.practice.day16.model.Photo

fun PhotoDto.toModel(): Photo = Photo(
    id = id ?: 0L,
    type = type.toPhotoType(),
    createdAt = createdAt.toLocalDate(),
    title = title ?: "제목 없음",
    content = content ?: "내용 없음",
    url = url,
    caption = caption ?: "",
)
