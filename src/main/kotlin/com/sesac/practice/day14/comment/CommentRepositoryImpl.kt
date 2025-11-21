package com.sesac.practice.day14.comment

class CommentRepositoryImpl(
    private val commentDataSource: CommentDataSource,
) : CommentRepository {

    override suspend fun getComments(postId: Int): List<Comment> {
        val comments = commentDataSource.getComments()

        return comments.filter { it.postId == postId }
    }
}
