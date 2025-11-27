package com.sesac.practice.day17.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Long? = null,
    val name: String? = null,
)
