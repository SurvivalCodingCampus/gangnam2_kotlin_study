package com.luca.kotlinstudy._18_result.mapper

import com.luca.kotlinstudy._18_result.dto.UserDTO
import com.luca.kotlinstudy._18_result.model.User

fun UserDTO.toUser(): User =
    User(
        userId = id ?: 0,
        name = name ?: "",
        userName = username ?: "",
        phone = phone ?: "",
    )

fun List<UserDTO>.toUsers(): List<User> =
    map { it.toUser() }

fun User.toDTO(): UserDTO =
    UserDTO(
        id = this.userId,
        name = this.name,
        username = this.userName,
        phone = this.phone
    )