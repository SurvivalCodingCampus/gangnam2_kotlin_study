package com.hhp227.kotlinstudy.`13_datasource`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class TodoDataSourceTest {
    val todoDataSource = TodoDataSourceImpl()

    @Test
    fun `파일이 존재하는지 확인`() {
        val todoJson = this::class.java.classLoader.getResource("todo.json")

        assertNotNull(todoJson, "todo.json 파일이 존재해야 합니다.")

        val todosJson = this::class.java.classLoader.getResource("todos.json")

        assertNotNull(todosJson, "todos.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `파일의 내용이 일치한지 확인`() {
        val jsonString = todoDataSource.loadFile<String>("todo.json").trimIndent()
        val expected = """{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}""".trimIndent()

        println(jsonString)
        println(expected)
        assertIs<String>(jsonString)
        assertEquals(expected, jsonString)
    }

    @Test
    fun `Todo객체를 비교해서 일치한지 테스트`() = runTest {
        val expected = Todo(1, 1, "delectus aut autem", false)
        val todo = todoDataSource.getTodo()

        assertEquals(expected, todo)
    }

    @Test
    fun `Todo리스트를 불러오는지 테스트`() = runTest {
        val todoList = todoDataSource.getTodos()

        assertIs<List<Todo>>(todoList)
    }

    @Test
    fun `Todo리스트 크기가 일치한지 테스트`() = runTest {
        val todoList = todoDataSource.getTodos()
        val expected = 200

        assertEquals(expected, todoList.size)
    }

    @Test
    fun `Todo리스트 첫번째 객체 테스트`() = runTest {
        val expected = Todo(1, 1, "delectus aut autem", false)
        val todoList = todoDataSource.getTodos()
        val firstTodo = todoList.first()

        assertEquals(expected, firstTodo)
    }

    @Test
    fun `Todo리스트 마지막 객체 테스트`() = runTest {
        val expected = Todo(10, 200, "ipsam aperiam voluptates qui", false)
        val todoList = todoDataSource.getTodos()
        val firstTodo = todoList.last()

        assertEquals(expected, firstTodo)
    }
}