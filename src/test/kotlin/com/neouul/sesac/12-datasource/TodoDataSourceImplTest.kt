package com.neouul.sesac.`12-datasource`

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class TodoDataSourceImplTest {
    @Test
    fun `인스턴스가 잘 생성되는가`() {
        val todoDataSourceImpl = TodoDataSourceImpl()

        assertTrue(todoDataSourceImpl is TodoDataSourceImpl)
        assertTrue(todoDataSourceImpl is TodoDataSource)
    }

    @Test
    fun `연습문제 1 - getTodo가 역직렬화하여 Todo를 잘 반환하는가`() = runBlocking {
        // given
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when
        val todo = todoDataSourceImpl.getTodo()

        // then
        assertTrue(todo is Todo)
        assertEquals(1, todo.userId)
        assertEquals(1, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertEquals(false, todo.completed)
    }

    @Test
    fun `연습문제 2 - getTodos가 역직렬화하여 List Todo를 잘 반환하는가`() = runBlocking {
        // given
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when
        val todos = todoDataSourceImpl.getTodos()

        // then
        todos.forEach {
            assertTrue(it is Todo)
            assertTrue(it.userId is Int)
            assertTrue(it.id is Int)
            assertTrue(it.title is String)
            assertTrue(it.completed is Boolean)
        }
    }
}