package com.luca.kotlinstudy._17_dto.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreList(
    @SerialName("count")
    val count: Int,
    @SerialName("stores")
    val stores: List<StoreDTO> = emptyList(),
)
