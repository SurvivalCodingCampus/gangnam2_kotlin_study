package com.hhp227.kotlinstudy.`16_dto`

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    val addr: String? = null,
    val code: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val lat: Double? = null,
    val lng: Double? = null,
    val name: String? = null,
    @SerialName("remain_stat")
    val remainStat: String? = null,
    @SerialName("stock_at")
    val stockAt: String? = null,
    val type: String? = null
) {
    fun toModel(): Store? {
        if (name.isNullOrBlank()) return null
        if (addr.isNullOrBlank()) return null
        if (lat == null || lng == null) return null
        if (remainStat.isNullOrBlank()) return null
        if (stockAt.isNullOrBlank()) return null
        return Store(
            name = name,
            address = addr,
            latitude = lat,
            longitude = lng,
            remainStat = remainStat,
            stockAt = stockAt
        )
    }
}