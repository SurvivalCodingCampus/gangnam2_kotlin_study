package _251121_ktor.exercise1to3.model


import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val body: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val userId: Int? = null
)