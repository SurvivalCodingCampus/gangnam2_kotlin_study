//package com.luca.kotlinstudy._18_photo.mapper
//
//import com.luca.kotlinstudy._17_dto.dto.PhotoDTO
//import com.luca.kotlinstudy._17_dto.model.Photo
//import com.luca.kotlinstudy._17_dto.model.PhotoType
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//import java.time.format.DateTimeParseException
//
//private val CREATED_AT_FORMATTER: DateTimeFormatter =
//    DateTimeFormatter.ofPattern("yyyy-MM-dd")
//
//fun String.toLocalDateOrNull(): LocalDate? =
//    try {
//        LocalDate.parse(this, CREATED_AT_FORMATTER)
//    } catch (e: DateTimeParseException) {
//        null
//    }
//
//private fun String?.toPhotoType(): PhotoType =
//    when (this) {
//        "article" -> PhotoType.Article
//        "image" -> PhotoType.Image
//        "video" -> PhotoType.Video
//        else -> PhotoType.Unknown
//    }
//
//
//fun PhotoDTO.toModelOrNull(): Photo? {
//    val localDate = createdAt?.toLocalDateOrNull() ?: return null
//
//    return Photo(
//        id = id,
//        type = type.toPhotoType(),
//        title = title,
//        content = content,
//        url = url,
//        caption = caption,
//        createdAt = localDate,
//    )
//}
