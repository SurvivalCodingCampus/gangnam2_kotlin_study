package com.sesac.practice.day14.comment

class MockCommentDataSourceImpl() : CommentDataSource {

    override suspend fun getComments(): List<Comment> {
        return listOf(
            Comment(1, 1, "name1", "email1", "body1"),
            Comment(1, 2, "name2", "email2", "body2"),
            Comment(2, 1, "name3", "email3", "body3"),
            Comment(2, 2, "name4", "email4", "body4"),
        )
    }
}
