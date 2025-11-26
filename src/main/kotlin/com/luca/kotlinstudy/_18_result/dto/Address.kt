package com.luca.kotlinstudy._18_result.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("city")
    val city: String? = null,
    @SerialName("geo")
    val geo: Geo? = null,
    @SerialName("street")
    val street: String? = null,
    @SerialName("suite")
    val suite: String? = null,
    @SerialName("zipcode")
    val zipcode: String? = null,
)