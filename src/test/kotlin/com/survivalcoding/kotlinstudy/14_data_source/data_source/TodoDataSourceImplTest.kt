package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs


class TodoDataSourceImplTest {
    companion object {
        private const val TODO_ID = 1
        private const val TODO_USER_ID = 1
        private const val TODO_TITLE = "delectus aut autem"
        private val dataSource = TodoDataSourceImpl()
        private const val TODOS_SIZE = 200

        private const val TODO_2_ID = 2
        private const val TODO_2_USER_ID = 1
        private const val TODO_2_TITLE = "quis ut nam facilis et officia qui"

    }

    @Test
    fun `Todo 역직렬화 성공`() = runBlocking {
        // when
        val todo = dataSource.getTodo()

        // then

        assertEquals(TODO_USER_ID, todo.userId)
        assertEquals(TODO_ID, todo.id)
        assertEquals(TODO_TITLE, todo.title)
        assertFalse(todo.completed)
    }


    @Test
    fun `Todos 역직렬화 성공`() = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // then
        assertIs<List<Todo>>(todos)
        assertEquals(TODOS_SIZE, todos.size)
    }


    @Test
    fun `Todos 리스트 역직렬화`() = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // when
        val todo1 = todos[0]
        val todo2 = todos[1]

        // then
        assertEquals(TODO_USER_ID, todo1.userId)
        assertEquals(TODO_ID, todo1.id)
        assertEquals(TODO_TITLE, todo1.title)
        assertFalse(todo1.completed)

        assertEquals(TODO_2_USER_ID, todo2.userId)
        assertEquals(TODO_2_ID, todo2.id)
        assertEquals(TODO_2_TITLE, todo2.title)
        assertFalse(todo2.completed)
    }
}