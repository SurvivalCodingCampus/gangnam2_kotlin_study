package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TodoDataSourceImplTest {
    @Test
    fun `json 데이터를 역직렬화해서 Todo 객체로 가져온다`() {
        // given
        val id = 1
        val userId = 1
        val title = "delectus aut autem"
        val completed = false

        val todo = Todo(id, userId, title, completed)

        runBlocking {
            // when
            val actual = TodoDataSourceImpl().getTodo()

            // then
            assertIs<List<Todo>>(actual)
            assertEquals(actual.size, 200)
            assertContains(actual, todo)
        }
    }
}