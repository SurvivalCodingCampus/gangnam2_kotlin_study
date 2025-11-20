package com.sesac.practice.day14.comment

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class CommentRepositoryImplTest {
    @Test
    fun `postId가 일치하는 Comment 리스트를 가져온다`() = runTest {
        // given
        val repository = CommentRepositoryImpl(
            object : CommentDataSource {
                override suspend fun getComments(): List<Comment> {
                    return listOf(
                        Comment(1, 1, "name1", "email1", "body1"),
                        Comment(1, 2, "name2", "email2", "body2"),
                        Comment(2, 1, "name3", "email3", "body3"),
                        Comment(2, 2, "name4", "email4", "body4"),
                    )
                }
            },
        )

        // when
        val postId = 1
        val comments = repository.getComments(postId)

        // then
        assertEquals(2, comments.size)
    }
}
