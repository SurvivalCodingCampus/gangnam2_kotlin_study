package com.neouul.sesac.`15-dto-mapper`.photos.core

import com.neouul.sesac.`15-dto-mapper`.photos.model.Type
import java.time.LocalDate

fun String.toType(): Type {
    return when (this) {
        "Article" -> Type.ARTICLE
        "Image" -> Type.IMAGE
        "Video" -> Type.VIDEO
        "Unknown" -> Type.UNKNOWN
        else -> Type.UNKNOWN
    }
}

fun String.toLocalDateOrNull(): LocalDate? {
    return runCatching { LocalDate.parse(this) }.getOrNull()
}