package com.survivalcoding.kotlinstudy.`18_result`.dto

import kotlinx.serialization.Serializable

// Post 요청시 간단하게만 보내도 ok
// 기본 인적사항만 보내보기
@Serializable
data class UserRequestDto(
    val name: String,
    val username: String,
    val email: String,
)

// Post 요청 응답
@Serializable
data class CreatedIdDto(
    val id: Int? = null
)