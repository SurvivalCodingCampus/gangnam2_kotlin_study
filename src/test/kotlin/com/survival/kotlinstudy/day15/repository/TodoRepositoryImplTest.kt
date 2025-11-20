package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.FileTodoDataSourceImpl
import com.survival.kotlinstudy.day15.model.Todo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class TodoRepositoryImplTest {

    @Test
    fun `TodoRepositoryImpl 의 getTodos() 테스트`(): Unit = runBlocking {
        val filePath = "data/todos.json"
        val repository = TodoRepositoryImpl(FileTodoDataSourceImpl(filePath))
        val expected = 200


        val list = repository.getTodos()


        assertEquals(expected, list.size)
        assertIs<List<Todo>>(list)


    }

    @Test
    fun `TodoRepositoryImpl 의 getCompletedTodos() 테스트`(): Unit = runBlocking {
        val filePath = "data/todos.json"
        val repository = TodoRepositoryImpl(FileTodoDataSourceImpl(filePath))


        val list = repository.getCompletedTodos()


        assertTrue { list.any { it.completed } }

    }
}