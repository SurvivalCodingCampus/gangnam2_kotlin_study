package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import java.io.File

class MockCommentDataSourceImpl(val file: File) : CommentDataSource {
    override suspend fun getComments() = listOf(
        Comment(1L, 1L, "comment1", "user1@gmail.com", "body1"),
        Comment(2L, 2L, "comment2", "user2@gmail.com", "body2")
    )
}