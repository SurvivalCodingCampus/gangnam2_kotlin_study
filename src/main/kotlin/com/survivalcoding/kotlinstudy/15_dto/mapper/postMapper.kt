package com.survivalcoding.kotlinstudy.`15_dto`.mapper

import com.survivalcoding.kotlinstudy.`15_dto`.dto.PostDto
import com.survivalcoding.kotlinstudy.`15_dto`.model.Post

fun PostDto.toModel(): Post {
    return Post(
        id = id ?: 0,
        title = title ?: "",
        contents = body ?: "",
    )
}