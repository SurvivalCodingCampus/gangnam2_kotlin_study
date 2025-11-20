package com.survivalcoding.kotlinstudy.`15_data_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source.MockTodoDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TodoRepositoryImplTest {

    companion object {
        private const val TOTAL_TODO_SIZE = 5
        private const val COMPLETED_TODO_SIZE = 1   // mock 데이터에서 completed=true는 1개
    }

    private val repo = TodoRepositoryImpl(MockTodoDataSourceImpl())

    @Test
    fun `전체 todos 리스트`() = runBlocking {
        // when
        val result = repo.getTodos()

        assertEquals(TOTAL_TODO_SIZE, result.size)
    }

    @Test
    fun `완료된 todos 필터링`() = runBlocking {
        // when
        val result = repo.getCompletedTodos()

        // then
        assertTrue(result.all { it.completed })
        assertEquals(COMPLETED_TODO_SIZE, result.size)
    }
}
