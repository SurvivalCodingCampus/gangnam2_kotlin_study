package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

class CommentRepositoryImpl(val dataSource: CommentDataSource) : CommentRepository {
    override suspend fun getComments(postId: Long): List<Comment> {
        val comments: List<Comment> = dataSource.getComments()

        return comments.filter { comment ->
            comment.postId == postId
        }
    }
}