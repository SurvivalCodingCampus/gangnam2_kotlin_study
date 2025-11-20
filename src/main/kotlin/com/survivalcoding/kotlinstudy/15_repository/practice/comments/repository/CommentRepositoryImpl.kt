package com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.data_source.CommentDataSource
import com.survivalcoding.kotlinstudy.`15_repository`.practice.comments.model.Comment

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
): CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        val commentSource = dataSource.getCommentsFileData()
        return commentSource.filter { it.postId == postId }
    }
}