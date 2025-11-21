package com.survival.kotlinstudy.day15.model

import com.survival.kotlinstudy.datasource.Address
import com.survival.kotlinstudy.datasource.Company
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)
