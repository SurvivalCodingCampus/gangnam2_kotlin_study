package com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.PhotoType

fun String?.toPhotoType(): PhotoType {
    return when (this?.lowercase()) {
        "article" -> PhotoType.ARTICLE
        "image" -> PhotoType.IMAGE
        "video" -> PhotoType.VIDEO
        else -> PhotoType.UNKNOWN
    }
}
