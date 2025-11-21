package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class CommentRepositoryImplTest {
    @Test
    fun `postId에 해당하는 Comment 리스트를 가져올 수 있다`() {
        // given
        val postId = 1L
        val postIdSize = 1

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockCommentDataSourceImpl(file)
        val commentRepository = CommentRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = commentRepository.getComments(postId)

            // then
            assertIs<List<Comment>>(actual)
            assertEquals(postIdSize, actual.size)
        }

    }

    @Test
    fun `존재하지 않는 postId는 빈 리스트를 가져온다`() {
        // given
        val postId = Long.MAX_VALUE
        val postIdSize = 0

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockCommentDataSourceImpl(file)
        val commentRepository = CommentRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = commentRepository.getComments(postId)

            // then
            assertEquals(postIdSize, actual.size)
        }

    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/first/"
        private const val FILE_NAME = "comment.json"
    }
}