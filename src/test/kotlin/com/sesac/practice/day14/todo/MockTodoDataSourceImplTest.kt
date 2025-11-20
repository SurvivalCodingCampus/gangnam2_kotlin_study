package com.sesac.practice.day14.todo

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MockTodoDataSourceImplTest {
    @Test
    fun `todos_json 파일을 읽어서 Todo 리스트로 반환한다`() = runTest {
        // given
        val pathname = "data/todos.json"
        val dataSource = MockTodoDataSourceImpl(pathname)

        // when
        val todos = dataSource.getTodos()

        // then
        assertEquals(200, todos.size)
    }
}
