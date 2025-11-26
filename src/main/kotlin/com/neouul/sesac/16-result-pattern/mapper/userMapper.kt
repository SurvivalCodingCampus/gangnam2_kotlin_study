package com.neouul.sesac.`16-result-pattern`.mapper

import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.`16-result-pattern`.model.User

fun UserDTO.toModel(): User {
    return User(
        userId = id ?: 0,
        name = name ?: "",
        userName = username ?: "",
        email = email ?: "",
        phone = phone ?: "",
    )
}