package _251125_dto_mapper.exercise1.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Store(
    @SerialName("addr")
    val addr: String? = null,
    @SerialName("code")
    val code: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("lat")
    val lat: Double? = 0.0,
    @SerialName("lng")
    val lng: Double? = 0.0,
    @SerialName("name")
    val name: String? = null,
    @SerialName("remain_stat")
    val remainStat: String? = null,
    @SerialName("stock_at")
    val stockAt: String? = null,
    @SerialName("type")
    val type: String? = null
)