package com.luca.kotlinstudy._18_result.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    @SerialName("address")
    val address: Address? = null,
    @SerialName("company")
    val company: Company? = null,
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
    val website: String? = null,
)