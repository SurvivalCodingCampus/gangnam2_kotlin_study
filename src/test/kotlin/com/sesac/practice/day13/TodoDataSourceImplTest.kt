package com.sesac.practice.day13

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class TodoDataSourceImplTest {
    @Test
    fun `todo_json 파일을 읽어서 Todo 객체로 변환한다`() = runTest {
        // given
        val filename = "data/todo.json"
        val dataSource = TodoDataSourceImpl(filename)

        // when
        val todo = dataSource.getTodo()

        // then
        assertEquals(1, todo.userId)
        assertEquals(1, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertEquals(false, todo.completed)
    }

    @Test
    fun `todos_json 파일을 읽어서 Todo 객체 리스트로 변환한다`() = runTest {
        // given
        val filename = "data/todos.json"
        val dataSource = TodoDataSourceImpl(filename)

        // when
        val todos = dataSource.getTodos()

        // then
        assertEquals(200, todos.size)
    }
}
