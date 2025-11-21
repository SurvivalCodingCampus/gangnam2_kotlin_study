package com.survivalcoding.kotlinstudy.repository.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("city")
    val city: String,
    @SerialName("geo")
    val geo: Geo,
    @SerialName("street")
    val street: String,
    @SerialName("suite")
    val suite: String,
    @SerialName("zipcode")
    val zipcode: String
)