package com.luca.kotlinstudy._15_model_repository.repository.comment

import com.luca.kotlinstudy._15_model_repository.dataSource.comment.MockCommentDatasourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class CommentRepositoryImplTest {

    private val mockDataSource = MockCommentDatasourceImpl()
    private val repository = CommentRepositoryImpl(mockDataSource)

    @Test
    fun `postId에 해당하는 댓글만 조회된다`() = runBlocking {
        val result = repository.getComments(1)

        assertTrue(result.isNotEmpty())
        assertTrue(result.all { it.postId == 1 })
    }

    @Test
    fun `해당 postId가 없으면 빈 리스트를 반환한다`() = runBlocking {
        val result = repository.getComments(999)

        assertTrue(result.isEmpty())
    }
}
