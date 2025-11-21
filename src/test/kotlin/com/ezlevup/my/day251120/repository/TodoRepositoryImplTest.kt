package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.MockTodoDataSourceImpl
import com.ezlevup.my.day251120.model.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TodoRepositoryImplTest {
    @Test
    fun `TodoRepositoryImpl 생성자`() {
        // given
        val todoRepository = TodoRepositoryImpl(MockTodoDataSourceImpl())

        // when & then
        assertNotNull(todoRepository)
    }

    @Test
    fun `TodoRepositoryImpl getTodos() 확인`(): Unit = runBlocking {
        // given
        val todos = listOf(
            Todo(userId = 1, id = 1, title = "lee1", completed = true),
            Todo(userId = 1, id = 2, title = "lee2", completed = false),
        )
        val todoRepository = TodoRepositoryImpl(MockTodoDataSourceImpl(todos))

        // when
        val result = todoRepository.getTodos()

        // then
        assertEquals(todos.count(), result.count())
    }

    @Test
    fun `TodoRepositoryImpl getCompletedTodos() 확인`(): Unit = runBlocking {
        // given
        val todos = listOf(
            Todo(userId = 1, id = 1, title = "lee1", completed = true),
            Todo(userId = 1, id = 2, title = "lee2", completed = false),
        )
        val todoRepository = TodoRepositoryImpl(MockTodoDataSourceImpl(todos))

        // when
        val result = todoRepository.getCompletedTodos()

        // then
        val falseCount = todos.count { it.completed }
        assertEquals(falseCount, result.count())
    }
}