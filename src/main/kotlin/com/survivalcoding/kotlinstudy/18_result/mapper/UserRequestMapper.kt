package com.survivalcoding.kotlinstudy.`18_result`.mapper

import com.survivalcoding.kotlinstudy.`18_result`.dto.UserRequestDto
import com.survivalcoding.kotlinstudy.`18_result`.model.User

fun User.toCreateRequestDto(): UserRequestDto {
    return UserRequestDto(
        name = name,
        username = username,
        email = email
    )
}
