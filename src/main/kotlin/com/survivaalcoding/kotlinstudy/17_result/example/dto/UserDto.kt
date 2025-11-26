package com.survivaalcoding.kotlinstudy.`17_result`.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Long? = null,
    val email: String? = null,
    val name: String? = null
)
