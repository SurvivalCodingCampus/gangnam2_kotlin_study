package com.survivaalcoding.kotlinstudy.`17_result`.example.mapper

import com.survivaalcoding.kotlinstudy.`17_result`.example.dto.UserDto
import com.survivaalcoding.kotlinstudy.`17_result`.example.model.User

fun UserDto.toModel(): User {
    return User(
        id = id ?: -1,
        email = email ?: "",
        name = name ?: ""
    )
}