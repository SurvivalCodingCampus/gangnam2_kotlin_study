package com.neouul.sesac.`13-modelClass-repository`.comments

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource,
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.jsonToComments().filter { it.postId == postId }
    }
}