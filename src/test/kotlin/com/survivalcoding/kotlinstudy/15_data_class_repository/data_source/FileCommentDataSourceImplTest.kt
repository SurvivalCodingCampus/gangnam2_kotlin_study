package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Comment
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class FileCommentDataSourceImplTest {
    companion object {
        private const val COMMENTS_SIZE = 500
    }


    private val dataSource = MockCommentDataSourceImpl()


    @Test
    fun `Comment 리스트 확인 - 리스트 모두 불러오기`(): Unit = runBlocking {
        // when
        val comments = dataSource.getComments()

        // then
        assertTrue(comments.isNotEmpty())
        assertEquals(COMMENTS_SIZE, comments.size)
        assertIs<List<Comment>>(comments)

    }

    @Test
    fun `Comment 역직렬화 - 타입 체크`() = runBlocking {
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