package com.neouul.sesac.`16-result-pattern`.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val id: Int? = null,
    val name: String? = null,
    val username: String? = null,
    val email: String? = null,
    val phone: String? = null,
)
