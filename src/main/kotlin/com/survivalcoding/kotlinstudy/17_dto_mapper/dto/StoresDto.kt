package com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoresDto(
    @SerialName("count")
    val count: Int? = null,

    @SerialName("stores")
    val stores: List<StoreDto>? = null
)