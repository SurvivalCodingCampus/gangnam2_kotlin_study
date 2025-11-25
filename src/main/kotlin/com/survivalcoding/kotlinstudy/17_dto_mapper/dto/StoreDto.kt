package com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    @SerialName("addr")
    val address: String,

    @SerialName("code")
    val code: String,

    @SerialName("created_at")
    val createdAt: String? = null,

    @SerialName("lat")
    val lat: Double,

    @SerialName("lng")
    val lng: Double,

    @SerialName("name")
    val name: String,

    @SerialName("remain_stat")
    val remainStat: String? = null,

    @SerialName("stock_at")
    val stockAt: String? = null,

    @SerialName("type")
    val type: String,
)
