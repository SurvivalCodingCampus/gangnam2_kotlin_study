package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class FileTodoDataSourceImplTest {
    companion object {
        private const val TODOS_SIZE = 200
    }

    private val dataSource = FileTodoDataSourceImpl()

    @Test
    fun `리스트 확인 - 리스트 모두 불러보기`(): Unit = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // then
        assertTrue(todos.isNotEmpty())
        assertEquals(TODOS_SIZE, todos.size)
        assertIs<List<Todo>>(todos)
    }

    @Test
    fun `역직렬화 - 타입 체크`() = runBlocking {
        // when
        val todos = dataSource.getTodos()

        // then
        todos.forEach {
            assertTrue(it is Todo)
            assertTrue(it.id is Int)
            assertTrue(it.userId is Int)
            assertTrue(it.title is String)
            assertTrue(it.completed is Boolean)
        }
    }
}