package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class TodoDataSourceImplTest {

    @Test
    fun `getTodo() 함수를 통해 JSON 데이터를 클래스로 변환`(): Unit = runBlocking {
        // given (준비)
        val todoDataSourceImpl = TodoDataSourceImpl()

        val expected = Todo(userId = 1, id = 1, title = "delectus aut autem", completed = false)

        // when (실행)
        val data: Todo = todoDataSourceImpl.getTodo()

        // then (검증)
        assertEquals(data, expected)
        assertEquals(data.id, expected.id)
        assertEquals(data.userId, expected.userId)
        assertEquals(data.title, expected.title)
        assertEquals(data.completed, expected.completed)
    }

    @Test
    fun `getTodos() 함수를 통해 JSON 데이터를 클래스로 변환`(): Unit = runBlocking {
        // given (준비)
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when (실행)
        val data: List<Todo> = todoDataSourceImpl.getTodos()

        // then (검증)
        assertIs<List<Todo>>(data)

    }
}