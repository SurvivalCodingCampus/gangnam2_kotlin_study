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
        todos.forEach { it is Todo }
        todos.forEach { it.id is Int }
        todos.forEach { it.userId is Int }
        todos.forEach { it.title is String }
        todos.forEach { it.completed is Boolean }
    }
}