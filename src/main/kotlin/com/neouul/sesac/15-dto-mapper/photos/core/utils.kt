package com.neouul.sesac.`15-dto-mapper`.photos.core

import com.neouul.sesac.`15-dto-mapper`.photos.model.Type

fun String.toType(): Type {
    return when (this) {
        "Article" -> Type.ARTICLE
        "Image" -> Type.IMAGE
        "Video" -> Type.VIDEO
        "Unknown" -> Type.UNKNOWN
        else -> Type.UNKNOWN
    }
}