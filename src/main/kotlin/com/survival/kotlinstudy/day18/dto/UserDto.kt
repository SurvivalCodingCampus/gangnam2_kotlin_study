package com.survival.kotlinstudy.day18.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int? = null,
    val name: String? = null,
)
