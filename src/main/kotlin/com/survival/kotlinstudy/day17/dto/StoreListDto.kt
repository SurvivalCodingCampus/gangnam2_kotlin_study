package com.survival.kotlinstudy.day17.dto


import kotlinx.serialization.Serializable

@Serializable
data class StoreListDto(
    val count: Int? = null,
    val stores: List<StoreDto>? = null
)