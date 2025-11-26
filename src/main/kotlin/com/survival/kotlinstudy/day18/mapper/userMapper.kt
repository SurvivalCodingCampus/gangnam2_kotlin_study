package com.survival.kotlinstudy.day18.mapper

import com.survival.kotlinstudy.day18.dto.UserDto
import com.survival.kotlinstudy.day18.model.User

fun UserDto.toModel(): User {
    return User(
        id = id ?: 0,
        name = name ?: "",
    )
}