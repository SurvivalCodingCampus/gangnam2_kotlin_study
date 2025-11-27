package _251126_result.exercise2.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val age: Int,
    val id: Int,
)
