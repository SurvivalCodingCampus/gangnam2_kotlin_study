package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class MockTodoDataSourceImplTest {
    @Test
    fun `Todo 데이터를 가져올 수 있다`() {
        // given
        val jsonSize = 3
        val expected = listOf(
            Todo(1L, 1L, "title1", true),
            Todo(2L, 2L, "title2", true),
            Todo(3L, 1L, "title3", false)
        )

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockTodoDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getTodo()

            // then
            assertIs<List<Todo>>(actual)
            assertEquals(jsonSize, actual.size)
            assertEquals(expected, actual)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/third/"
        private const val FILE_NAME = "todos.json"
    }
}