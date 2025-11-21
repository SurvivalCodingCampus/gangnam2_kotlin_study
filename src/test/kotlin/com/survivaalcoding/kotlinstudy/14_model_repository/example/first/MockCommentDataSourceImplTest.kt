package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class MockCommentDataSourceImplTest {
    @Test
    fun `Comment 리스트를 가져올 수 있다`() {
        // given
        val jsonSize = 2
        val expected = listOf(
            Comment(1L, 1L, "comment1", "user1@gmail.com", "body1"),
            Comment(2L, 2L, "comment2", "user2@gmail.com", "body2")
        )

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockCommentDataSourceImpl(file)

        runBlocking {
            // when
            val comments = mockDataSource.getComments()

            // then
            assertEquals(jsonSize, comments.size)
            assertEquals(expected, comments)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/first/"
        private const val FILE_NAME = "comment.json"
    }
}