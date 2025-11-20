package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.CommentDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Comment

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getComments()
            .filter { it.postId == postId }
    }
}