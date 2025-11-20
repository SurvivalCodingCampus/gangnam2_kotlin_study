package com.sesac.practice.day14.todo

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class TodoRepositoryImplTest {

    private val dataSource = MockTodoDataSourceImpl()

    @Test
    fun `Todo 리스트를 가져온다`() = runTest {
        // given
        val repository = TodoRepositoryImpl(dataSource)

        // when
        val todos = repository.getTodos()

        // then
        assertEquals(3, todos.size)
    }

    @Test
    fun `Completed 상태인 Todo 리스트를 가져온다`() = runTest {
        // given
        val repository = TodoRepositoryImpl(dataSource)

        // when
        val todos = repository.getCompletedTodos()

        // then
        assertEquals(2, todos.size)
    }
}
