package _251126_result.exercise2.mapper

import _251126_result.exercise2.dto.UserDto
import _251126_result.exercise2.model.User

fun UserDto.toModel(): User {
    return User(
        name = this.name ?: "",
        age = this.age ?: 0,
        id = this.id ?: 0
    )
}