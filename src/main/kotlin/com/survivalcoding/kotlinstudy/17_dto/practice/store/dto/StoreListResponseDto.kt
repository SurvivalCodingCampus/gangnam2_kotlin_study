package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreListResponseDto(
    val count: Int,
    val stores: List<StoreDto>
)