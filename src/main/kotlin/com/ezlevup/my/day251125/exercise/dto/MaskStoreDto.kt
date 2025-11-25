package com.ezlevup.my.day251125.exercise.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MaskStoreDto(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("stores")
    val stores: List<StoreDto?>? = null
)