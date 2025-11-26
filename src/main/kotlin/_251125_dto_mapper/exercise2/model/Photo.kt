package _251125_dto_mapper.exercise2.model

import java.time.LocalDate

data class Photo(
    val caption: String,
    val content: String,
    val createdAt: LocalDate,
    val id: Int,
    val title: String,
    val type: Enum<PhotoType>,
    val url: String
)

