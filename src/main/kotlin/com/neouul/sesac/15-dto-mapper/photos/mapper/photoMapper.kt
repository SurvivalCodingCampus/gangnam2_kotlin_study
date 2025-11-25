package com.neouul.sesac.`15-dto-mapper`.photos.mapper

import com.neouul.sesac.`15-dto-mapper`.photos.core.EMPTY_INT
import com.neouul.sesac.`15-dto-mapper`.photos.core.EMPTY_LOCALDATE
import com.neouul.sesac.`15-dto-mapper`.photos.core.EMPTY_STRING
import com.neouul.sesac.`15-dto-mapper`.photos.core.toType
import com.neouul.sesac.`15-dto-mapper`.photos.dto.PhotoDTO
import com.neouul.sesac.`15-dto-mapper`.photos.model.Photo
import com.neouul.sesac.`15-dto-mapper`.photos.model.Type
import java.time.LocalDate

fun PhotoDTO.toModel(): Photo {
    return Photo(
        id = id?.toIntOrNull() ?: EMPTY_INT,
        type = type?.toType() ?: Type.UNKNOWN,
        url = url ?: EMPTY_STRING,
        title = title ?: EMPTY_STRING,
        content = content ?: EMPTY_STRING,
        caption = caption ?: EMPTY_STRING,
        createdAt = LocalDate.parse(created_at) ?: EMPTY_LOCALDATE,
    )
}