package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.CommentDataSource
import com.survival.kotlinstudy.day15.model.Comment

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getComments().filter { it.postId == postId }
    }

}