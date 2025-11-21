package com.survivalcoding.kotlinstudy

import com.survivalcoding.kotlinstudy.repository.model.Address
import com.survivalcoding.kotlinstudy.repository.model.Company


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("address")
    val address: Address,
    @SerialName("company")
    val company: Company,
    @SerialName("email")
    val email: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("username")
    val username: String,
    @SerialName("website")
    val website: String
)