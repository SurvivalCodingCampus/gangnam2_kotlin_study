package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._14_dataSource.TodoDataSourceImpl.Companion.todoFilePath
import com.luca.kotlinstudy._14_dataSource.TodoDataSourceImpl.Companion.todosFilePath
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test


class TodoTest {
    @Test
    fun `todo 값이 잘 들어갔나 확인`() = runBlocking {
        val dataSource = TodoDataSourceImpl(todoFilePath)
        val todo = dataSource.getTodo()

        val expected = Todo(
            userId = 1,
            id = 1,
            title = "delectus aut autem",
            completed = false
        )

        assertEquals(expected, todo)
    }

    @Test
    fun `todos 값이 잘 들어갔나 확인`() = runBlocking {
        val dataSource = TodoDataSourceImpl(todosFilePath)
        val todos = dataSource.getTodos()

        val expected = Todo(
            userId = 1,
            id = 1,
            title = "delectus aut autem",
            completed = false
        )

        assertEquals(expected, todos.first())
    }
}
