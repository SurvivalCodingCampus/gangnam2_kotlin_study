package com.ezlevup.my.day251126.exercise.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("address")
    val addressDto: AddressDto? = null,
    @SerialName("company")
    val companyDto: CompanyDto? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("website")
    val website: String? = null
)