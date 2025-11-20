package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.CommentDataSource
import com.survival.kotlinstudy.day15.datasource.MockCommentDataSourceImpl
import com.survival.kotlinstudy.day15.model.Comment
import kotlinx.coroutines.runBlocking

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        val list = dataSource.getComments()
        return list.filter { it.postId == postId }
    }

}


fun main(): Unit = runBlocking{
    val filePath = "data/comments.json"
    val repository = CommentRepositoryImpl(MockCommentDataSourceImpl(filePath))

}