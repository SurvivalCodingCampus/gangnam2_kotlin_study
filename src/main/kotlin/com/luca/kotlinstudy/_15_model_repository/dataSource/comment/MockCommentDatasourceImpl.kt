package com.luca.kotlinstudy._15_model_repository.dataSource.comment

import com.luca.kotlinstudy._15_model_repository.model.Comment

// 테스트에서 사용할 Mock DataSource (테스트 더블)
class MockCommentDatasourceImpl : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        val all = listOf(
            Comment(1, 1, "Luca", "luca@test.com", "Hello"),
            Comment(1, 2, "Min", "min@test.com", "Hi"),
            Comment(2, 3, "Other", "other@test.com", "World")
        )
        val comments = all.filter { it.postId == postId }
        return comments
    }
}
