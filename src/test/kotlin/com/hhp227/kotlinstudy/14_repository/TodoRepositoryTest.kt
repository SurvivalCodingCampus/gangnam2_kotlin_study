package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TodoRepositoryTest {
    private val todoRepository = TodoRepositoryImpl(MockTodoDataSourceImpl(filename = "todos.json"))

    @Test
    fun `TodoRepository에서 모든 Todo들을 가져와서 크기가 맞는지 테스트`() = runTest {
        val todoList = todoRepository.getTodos()
        val expected = 200

        assertEquals(expected, todoList.size)
    }

    @Test
    fun `TodoRepository에서 completed한것, completed하지 않은것 각각 하나씩 가져와서 포함되어있는지 테스트`() = runTest {
        val completedTodoList = todoRepository.getCompletedTodos()
        val completed = Todo(
            userId = 10,
            id = 191,
            title = "temporibus atque distinctio omnis eius impedit tempore molestias pariatur",
            isCompleted = true
        )
        val notCompleted = Todo(
            userId = 10,
            id = 200,
            title = "ipsam aperiam voluptates qui",
            isCompleted = false
        )

        assertTrue(completed in completedTodoList)
        assertTrue(notCompleted !in completedTodoList)
    }
}