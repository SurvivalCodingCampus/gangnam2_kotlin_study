package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class MockTodoDataSourceImplTest {
    @Test
    fun `json 파일 데이터를 Todo로 역직렬화 할 수 있다`() {
        // given
        val jsonSize = 200

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockTodoDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getTodo()

            // then
            assertEquals(jsonSize, actual.size)
        }
    }

    companion object {
        private const val DIR_PATH = "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/third/"
        private const val FILE_NAME = "todos.json"
    }
}