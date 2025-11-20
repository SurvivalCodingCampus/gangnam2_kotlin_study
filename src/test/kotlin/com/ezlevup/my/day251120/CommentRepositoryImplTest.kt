package com.ezlevup.my.day251120

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CommentRepositoryImplTest {
    @Test
    fun `CommentRepositoryImpl 생성자`() {
        // given
        val commentRepository = CommentRepositoryImpl(MockCommentDatasourceImpl())

        // when & then
        assertNotNull(commentRepository)
    }

    @Test
    fun `CommentRepositoryImpl getComments 호출`(): Unit = runBlocking {
        // given
        val commentRepository = CommentRepositoryImpl(MockCommentDatasourceImpl())

        // when
        val comments = commentRepository.getComments(1)

        // then
        assertNotNull(comments)
    }

    @Test
    fun `CommentRepositoryImpl getComments 값확인`(): Unit = runBlocking {
        // given
        val commentRepository = CommentRepositoryImpl(MockCommentDatasourceImpl())

        // when
        val comments = commentRepository.getComments(1)
        val comment = comments[0]
        
        // then
        val name: String = "lee1"
        assertEquals(name, comment.name)
    }
}