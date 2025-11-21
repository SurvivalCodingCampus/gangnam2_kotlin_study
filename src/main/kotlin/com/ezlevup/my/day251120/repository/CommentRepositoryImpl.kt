package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.CommentDataSource
import com.ezlevup.my.day251120.model.Comment

class CommentRepositoryImpl(
    val commentDataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return commentDataSource.getComments(postId)
    }
}
