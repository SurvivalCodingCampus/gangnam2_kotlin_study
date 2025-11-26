package com.sesac.kotlinstudy.day16.dto

fun PostDto.toModel(): Post {
    return Post(
        id = id ?: 0,
        title = title ?: "",
        contents = body ?: "",
    )
}
