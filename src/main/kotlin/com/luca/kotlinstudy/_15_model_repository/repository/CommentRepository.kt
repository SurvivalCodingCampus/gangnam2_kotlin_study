package com.luca.kotlinstudy._15_model_repository.repository

import com.luca.kotlinstudy._15_model_repository.model.Comment

// 댓글 데이터를 외부(DataSource)로부터 가져와 UI에 제공하는 Repository 규약
interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}