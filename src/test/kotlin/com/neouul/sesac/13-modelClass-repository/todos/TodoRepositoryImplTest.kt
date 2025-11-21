package com.neouul.sesac.`13-modelClass-repository`.todos

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class TodoRepositoryImplTest {
    @Test
    fun `getTodos가 Todo List를 반환하는지 - TodoDataSourceImpl`() = runBlocking {
        // given:
        val todoDataSource = TodoDataSourceImpl()     // 경로가 디폴트값으로 설정되어 있음
        val todoRepository = TodoRepositoryImpl(todoDataSource)

        // when:
        val result = todoRepository.getTodos()

        // then:
        result.forEach {
            assertTrue(it is Todo)
            assertTrue(it.userId is Int)
            assertTrue(it.id is Int)
            assertTrue(it.title is String)
            assertTrue(it.completed is Boolean)
        }
    }

    @Test
    fun `getTodos가 Todo List를 반환하는지 - Mocking`() = runBlocking {
        // given:
        // TodoDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관없이
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<TodoDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadTodos() } returns listOf(
            Todo(1, 11, "a", false),
            Todo(1, 12, "b", true),
            Todo(1, 13, "c", false),
            Todo(2, 14, "d", false),
            Todo(3, 15, "e", true),
            Todo(3, 16, "f", true),
        )
        val todoRepository = TodoRepositoryImpl(mockDataSource)

        // when:
        val result = todoRepository.getTodos()

        // then:
        // 6개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(1, result[0].userId)
        assertEquals(11, result[0].id)
        assertEquals("a", result[0].title)
        assertEquals(false, result[0].completed)

        assertEquals(1, result[1].userId)
        assertEquals(12, result[1].id)
        assertEquals("b", result[1].title)
        assertEquals(true, result[1].completed)

        assertEquals(1, result[2].userId)
        assertEquals(13, result[2].id)
        assertEquals("c", result[2].title)
        assertEquals(false, result[2].completed)

        assertEquals(2, result[3].userId)
        assertEquals(14, result[3].id)
        assertEquals("d", result[3].title)
        assertEquals(false, result[3].completed)

        assertEquals(3, result[4].userId)
        assertEquals(15, result[4].id)
        assertEquals("e", result[4].title)
        assertEquals(true, result[4].completed)

        assertEquals(3, result[5].userId)
        assertEquals(16, result[5].id)
        assertEquals("f", result[5].title)
        assertEquals(true, result[5].completed)
    }

    @Test
    fun `getCompletedTodos가 completed가 true인 데이터를 반환하는지 - TodoDataSourceImpl`() = runBlocking {
        // given:
        val todoDataSource = TodoDataSourceImpl()     // 경로가 디폴트값으로 설정되어 있음
        val todoRepository = TodoRepositoryImpl(todoDataSource)

        // when:
        val result = todoRepository.getCompletedTodos()

        // then:
        result.forEach {
            assertEquals(true, it.completed)
        }
    }

    @Test
    fun `getCompletedTodos가 completed가 true인 데이터를 반환하는지 - Mocking`() = runBlocking {
        // given:
        // TodoDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관없이
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<TodoDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadTodos() } returns listOf(
            Todo(1, 11, "a", false),
            Todo(1, 12, "b", true),
            Todo(1, 13, "c", false),
            Todo(2, 14, "d", false),
            Todo(3, 15, "e", true),
            Todo(3, 16, "f", true),
        )
        val todoRepository = TodoRepositoryImpl(mockDataSource)

        // when:
        val result = todoRepository.getCompletedTodos()

        // then:
        // 3개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(1, result[0].userId)
        assertEquals(12, result[0].id)
        assertEquals("b", result[0].title)
        assertEquals(true, result[0].completed)

        assertEquals(3, result[1].userId)
        assertEquals(15, result[1].id)
        assertEquals("e", result[1].title)
        assertEquals(true, result[1].completed)

        assertEquals(3, result[2].userId)
        assertEquals(16, result[2].id)
        assertEquals("f", result[2].title)
        assertEquals(true, result[2].completed)
    }
}