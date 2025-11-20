package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Comment
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MockCommentDataSourceImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 3
        private const val POST_ID = 1
    }

    private val dataSource = MockCommentDataSourceImpl()

    @Test
    fun `Comment mock 데이터 - 리스트 검사`(): Unit = runBlocking {
        // when
        val comments = dataSource.getComments()

        // then
        assertTrue(comments.isNotEmpty())
        assertEquals(MOCK_DATA_SIZE, comments.size)
        assertIs<List<Comment>>(comments)

    }

    @Test
    fun `Comment Album mock 데이터 - 필드 타입 검사`() = runBlocking {
        // when
        val comments = dataSource.getComments()

        // then
        comments.forEach {
            assertTrue { it is Comment }
            assertTrue { it.postId is Int }
            assertTrue { it.id is Int }
            assertTrue { it.name is String }
            assertTrue { it.body is String }
            assertTrue { it.email is String }
        }
    }
}
