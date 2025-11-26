package com.sesac.practice.day17.mapper

import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.model.User

fun UserDto?.toModel(): User? {
    if (this == null || id == null) {
        return null
    }

    return User(
        id = this.id,
        name = this.name ?: "noname",
    )
}
