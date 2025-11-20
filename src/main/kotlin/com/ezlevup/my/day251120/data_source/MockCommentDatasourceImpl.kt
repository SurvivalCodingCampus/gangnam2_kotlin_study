package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Comment

class MockCommentDatasourceImpl(
    val fileName: String = "no-file.json",
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        return listOf(
            Comment(postId = 1, id = 1, name = "lee1", email = "lee1@naver.com", body = "f1"),
            Comment(postId = 1, id = 2, name = "lee1", email = "lee2@naver.com", body = "f2"),
        )
    }
}
