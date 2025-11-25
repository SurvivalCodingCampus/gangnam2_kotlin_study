package com.hhp227.kotlinstudy.`16_dto`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class PhotoDto(
    val id: Int? = null,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null
) {
    fun toModel(): Photo? {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val id = id?.toString() ?: return null
        val createdAtStr = createdAt ?: return null
        val type = when (type?.lowercase()) {
            "article" -> PhotoType.Article
            "image" -> PhotoType.Image
            "video" -> PhotoType.Video
            else -> PhotoType.Unknown
        }
        val createdAt = try {
            LocalDate.parse(createdAtStr, dateFormatter)
        } catch (e: Exception) {
            return null
        }
        return Photo(
            id = id,
            type = type,
            title = title,
            content = content,
            url = url,
            caption = caption,
            createdAt = createdAt
        )
    }
}