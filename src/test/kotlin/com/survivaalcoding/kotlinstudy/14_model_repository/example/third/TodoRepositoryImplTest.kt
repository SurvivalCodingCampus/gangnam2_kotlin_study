package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class TodoRepositoryImplTest {
    @Test
    fun `Todo 전체 데이터를 조회한다`() {
        // given
        val dataSize = 3
        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockTodoDataSourceImpl(file)

        val repository = TodoRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getTodos()

            // then
            assertIs<List<Todo>>(actual)
            assertEquals(dataSize, actual.size)
        }
    }

    @Test
    fun `completed 상태가 true인 것만 조회한다`() {
        // given
        val expectedSize = 2
        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockTodoDataSourceImpl(file)

        val repository = TodoRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getCompletedTodos()

            // then
            assertIs<List<Todo>>(actual)
            assertEquals(expectedSize, actual.size)
            assertTrue(actual.all { it.completed })
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/third/"
        private const val FILE_NAME = "todos.json"
    }
}