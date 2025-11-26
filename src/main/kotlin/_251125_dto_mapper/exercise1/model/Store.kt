package _251125_dto_mapper.exercise1.model


import kotlinx.serialization.Serializable

@Serializable
data class Store(
    val addr: String,
    val code: String,
    val createdAt: String,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String,
    val stockAt: String,
    val type: String
)