package com.neouul.sesac.`12-datasource`

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class TodoDataSourceImplTest {
    @Test
    fun `인스턴스가 잘 생성되는가`() {
        val todoDataSourceImpl = TodoDataSourceImpl()

        assertTrue(todoDataSourceImpl is TodoDataSourceImpl)
        assertTrue(todoDataSourceImpl is TodoDataSource)
    }

    @Test
    fun `연습문제 1 - getTodo가 역직렬화하여 Todo를 잘 반환하는가`() = runBlocking {
        // given
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when
        val todo = todoDataSourceImpl.getTodo()

        // then
        assertTrue(todo is Todo)
        assertEquals(1, todo.userId)
        assertEquals(1, todo.id)
        assertEquals("delectus aut autem", todo.title)
        assertEquals(false, todo.completed)
    }

    @Test
    fun `연습문제 2 - getTodos가 역직렬화하여 List Todo를 잘 반환하는가`() = runBlocking {
        // given
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when
        val todos = todoDataSourceImpl.getTodos()

        // then
        todos.forEach {
            assertTrue(it is Todo)
            assertTrue(it.userId is Int)
            assertTrue(it.id is Int)
            assertTrue(it.title is String)
            assertTrue(it.completed is Boolean)
        }
    }

    @Test
    fun `연습문제 3 - getUsers가 역직렬화하여 List User를 잘 반환하는가`() = runBlocking {
        // given
        val todoDataSourceImpl = TodoDataSourceImpl()

        // when
        val users = todoDataSourceImpl.getUsers()

        // then
        users.forEach {
            assertTrue(it is User)
            assertTrue(it.id is Int)
            assertTrue(it.name is String)
            assertTrue(it.username is String)
            assertTrue(it.email is String)

            assertTrue(it.address is Address)
            assertTrue(it.address.street is String)
            assertTrue(it.address.suite is String)
            assertTrue(it.address.city is String)
            assertTrue(it.address.zipcode is String)

            assertTrue(it.address.geo is Geo)
            assertTrue(it.address.geo.lat is String)
            assertTrue(it.address.geo.lng is String)

            assertTrue(it.phone is String)
            assertTrue(it.website is String)

            assertTrue(it.company is Company)
            assertTrue(it.company.name is String)
            assertTrue(it.company.catchPhrase is String)
            assertTrue(it.company.bs is String)
        }
    }
}