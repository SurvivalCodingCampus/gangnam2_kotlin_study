package com.luca.kotlinstudy._15_model_repository.repository.todo

import com.luca.kotlinstudy._15_model_repository.dataSource.todo.MockTodoDatasourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class TodoRepositoryImplTest {

    private val mockDataSource = MockTodoDatasourceImpl()
    private val repository = TodoRepositoryImpl(mockDataSource)

    @Test
    fun `getTodos 는 전체 Todo 목록을 반환한다`() = runBlocking {
        val result = repository.getTodos()

        assertTrue(result.isNotEmpty())
    }

    @Test
    fun `getCompletedTodos 는 completed 가 true 인 Todo 만 반환한다`() = runBlocking {
        val result = repository.getCompletedTodos()

        assertTrue(result.isNotEmpty())
        assertTrue(result.all { it.completed })
    }
}
