package com.ezlevup.my.day251126.exercise.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    @SerialName("city")
    val city: String? = null,
    @SerialName("geo")
    val geoDto: GeoDto? = null,
    @SerialName("street")
    val street: String? = null,
    @SerialName("suite")
    val suite: String? = null,
    @SerialName("zipcode")
    val zipcode: String? = null
)