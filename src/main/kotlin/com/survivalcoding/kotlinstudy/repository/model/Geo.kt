package com.survivalcoding.kotlinstudy.repository.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    @SerialName("lat")
    val lat: String,
    @SerialName("lng")
    val lng: String
)