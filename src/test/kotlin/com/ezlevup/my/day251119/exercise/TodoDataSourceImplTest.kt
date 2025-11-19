package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertNotNull

class TodoDataSourceImplTest {
    @Test
    fun `Todo 생성자`() {
        // given
        val todoDataSource = TodoDataSourceImpl()

        // when & then
        assertNotNull(todoDataSource)
    }


    @Test
    fun `Todo 데이터 가지고 오기`() = runBlocking {
        // given
        val todoDataSource = TodoDataSourceImpl()

        // when
        val todo = todoDataSource.getTodo()

        // then
        assertNotNull(todo)
        assertEquals(1L, todo.userId)
        assertEquals(1L, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertFalse(todo.completed)
    }

}