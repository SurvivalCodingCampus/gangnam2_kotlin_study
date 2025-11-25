package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    @SerialName("addr")
    val address: String? = null,
    val code: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val lat: Double? = 0.0,
    val lng: Double? = 0.0,
    val name: String? = null,
    @SerialName("remain_stat")
    val remainStat: String? = null,
    @SerialName("stock_at")
    val stockAt: String? = null,
    val type: String? = null
)

@Serializable
data class StoreResponse(val count: Int, val stores: List<StoreDto>)

fun StoreDto.isValid(): Boolean {
    return !remainStat.isNullOrBlank() &&
            !stockAt.isNullOrBlank() &&
            !createdAt.isNullOrBlank()
}