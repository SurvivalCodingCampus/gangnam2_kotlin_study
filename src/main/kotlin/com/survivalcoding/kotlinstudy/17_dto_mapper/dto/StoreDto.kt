package com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    @SerialName("addr")
    val address: String? = null,

    @SerialName("code")
    val code: String? = null,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("lat")
    val lat: Double? = null,

    @SerialName("lng")
    val lng: Double? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("remain_stat")
    val remainStat: String? = null,

    @SerialName("stock_at")
    val stockAt: String? = null,

    @SerialName("type")
    val type: String? = null,
)
