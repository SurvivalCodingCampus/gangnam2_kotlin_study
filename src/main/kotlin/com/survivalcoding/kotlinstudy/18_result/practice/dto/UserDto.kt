package com.survivalcoding.kotlinstudy.`18_result`.practice.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
    val address: AddressDto? = null,
    val phone: String? = null,
    val website: String? = null,
    val company: CompanyDto? = null
)

@Serializable
data class AddressDto(
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipcode: String? = null,
    val geo: GeoDto? = null
)

@Serializable
data class GeoDto(
    val lat: String? = null,
    val lng: String? = null
)

@Serializable
data class CompanyDto(
    val name: String? = null,
    val catchPhrase: String? = null,
    val bs: String? = null
)
