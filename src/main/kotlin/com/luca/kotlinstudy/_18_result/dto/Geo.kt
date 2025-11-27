package com.luca.kotlinstudy._18_result.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    @SerialName("lat")
    val lat: String? = null,
    @SerialName("lng")
    val lng: String? = null,
)