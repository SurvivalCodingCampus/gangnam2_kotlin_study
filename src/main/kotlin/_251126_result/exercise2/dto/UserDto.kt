package _251126_result.exercise2.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val name: String? = "",
    val age: Int? = 0,
    val id: Int? = 0
)
