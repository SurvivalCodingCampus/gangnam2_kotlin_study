package com.luca.kotlinstudy._15_model_repository.repository.comment

import com.luca.kotlinstudy._15_model_repository.dataSource.comment.CommentDataSource
import com.luca.kotlinstudy._15_model_repository.model.Comment

// CommentDataSource를 사용해 실제 데이터를 가져오는 Repository 구현체
class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        val comments = dataSource.getComments(postId)
        return comments
    }
}