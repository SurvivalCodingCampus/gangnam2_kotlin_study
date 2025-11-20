package com.neouul.sesac.`13-modelClass-repository`

import kotlinx.serialization.Serializable

// model class
// 1. data class로 정의
// 2. 메서드 없는 순수 클래스
// 3. 모든 필드는 val (불변)
@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
)