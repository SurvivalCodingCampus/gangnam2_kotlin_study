package com.sesac.practice.day16.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoresDto(
    val count: Int? = null,
    val stores: List<StoreDto>? = null,
)
