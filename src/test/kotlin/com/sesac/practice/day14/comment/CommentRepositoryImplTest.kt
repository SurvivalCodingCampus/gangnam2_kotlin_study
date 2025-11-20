package com.sesac.practice.day14.comment

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class CommentRepositoryImplTest {

    private val dataSource = MockCommentDataSourceImpl()

    @Test
    fun `postId가 일치하는 Comment 리스트를 가져온다`() = runTest {
        // given
        val repository = CommentRepositoryImpl(dataSource)

        // when
        val postId = 1
        val comments = repository.getComments(postId)

        // then
        assertEquals(2, comments.size)
    }
}
