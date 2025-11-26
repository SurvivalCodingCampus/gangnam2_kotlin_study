package com.ezlevup.my.day251126.exercise.mapper

import com.ezlevup.my.day251126.exercise.dto.UserDto
import com.ezlevup.my.day251126.exercise.model.User

fun UserDto.toUser(): User {
    return User(
        id = this.id ?: 0,
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = this.id,
    )
}
