package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class TodoDataSourceTest {
    val todoDataSource = MockTodoDataSourceImpl(filename = "todos.json")

    @Test
    fun `파일이 존재하는지 확인`() {
        val todosJson = this::class.java.classLoader.getResource("todos.json")

        assertNotNull(todosJson, "todos.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `Todo리스트를 불러오는지 테스트`() = runTest {
        val todoList = todoDataSource.getAllTodos()

        assertIs<List<Todo>>(todoList)
    }

    @Test
    fun `Todo리스트 크기가 일치한지 테스트`() = runTest {
        val todoList = todoDataSource.getAllTodos()
        val expected = 200

        assertEquals(expected, todoList.size)
    }

    @Test
    fun `Todo리스트 첫번째 객체 테스트`() = runTest {
        val expected = Todo(1, 1, "delectus aut autem", false)
        val todoList = todoDataSource.getAllTodos()
        val firstTodo = todoList.first()

        assertEquals(expected, firstTodo)
    }

    @Test
    fun `Todo리스트 마지막 객체 테스트`() = runTest {
        val expected = Todo(10, 200, "ipsam aperiam voluptates qui", false)
        val todoList = todoDataSource.getAllTodos()
        val lastTodo = todoList.last()

        assertEquals(expected, lastTodo)
    }
}