package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MockTodoDataSourceImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 5
    }

    private val dataSource = MockTodoDataSourceImpl()

    @Test
    fun `Todo 데이터 - 리스트 검사`(): Unit = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // then
        assertTrue(todos.isNotEmpty())
        assertEquals(MOCK_DATA_SIZE, todos.size)
        assertIs<List<Todo>>(todos)
    }

    fun `Todo 데이터 - 필드 타입 검사`() = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // then
        todos.forEach { todo ->
            assertTrue(todo is Todo)
            assertTrue(todo.userId is Int)
            assertTrue(todo.id is Int)
            assertTrue(todo.title is String)
            assertTrue(todo.completed is Boolean)
        }
    }
}
