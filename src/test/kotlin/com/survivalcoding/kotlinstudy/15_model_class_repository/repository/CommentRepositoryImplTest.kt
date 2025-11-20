package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.MockCommentDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CommentRepositoryImplTest {

    companion object {
        private const val POST_ID = 1
        private const val MOCK_COMMENTS_SIZE = 3
        private const val NOT_EXIST_POST_ID = 999
    }

    private val repo = CommentRepositoryImpl(MockCommentDataSourceImpl())

    @Test
    fun `postId로 댓글 필터링`() = runBlocking {
        // when
        val result = repo.getComments(POST_ID)

        // then
        assertTrue(result.all { it.postId == POST_ID })
        assertEquals(MOCK_COMMENTS_SIZE, result.size)
    }

    @Test
    fun `존재하지 않는 postId - 빈 리스트`() = runBlocking {
        // when
        val result = repo.getComments(NOT_EXIST_POST_ID)

        // then
        assertTrue(result.isEmpty())
    }
}
