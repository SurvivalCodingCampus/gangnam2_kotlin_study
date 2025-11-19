package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._14_dataSource.TodoListDataSourceImpl.Companion.usersFilePath
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class UserTest {
    @Test
    fun `users 값이 잘 들어갔나 확인`() = runBlocking {
        val dataSource: UserDataSource = TodoListDataSourceImpl(usersFilePath)
        val users = dataSource.getUsers()

        assertTrue(users.isNotEmpty())
        val firstUser = users.first()

        assertEquals(1, firstUser.id)
        assertEquals("Leanne Graham", firstUser.name)
        assertEquals("Bret", firstUser.username)
        assertEquals("Sincere@april.biz", firstUser.email)

        // address
        assertEquals("Kulas Light", firstUser.address.street)
        assertEquals("Apt. 556", firstUser.address.suite)
        assertEquals("Gwenborough", firstUser.address.city)
        assertEquals("92998-3874", firstUser.address.zipcode)

        // geo
        assertEquals("-37.3159", firstUser.address.geo.lat)
        assertEquals("81.1496", firstUser.address.geo.lng)

        // company
        assertEquals("Romaguera-Crona", firstUser.company.name)
        assertEquals("Multi-layered client-server neural-net", firstUser.company.catchPhrase)
        assertEquals("harness real-time e-markets", firstUser.company.bs)
    }
}