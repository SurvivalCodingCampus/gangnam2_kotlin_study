package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryTest {
    private val userRepository = UserRepositoryImpl(MockUserDataSourceImpl(filename = "users.json"))

    @Test
    fun `UserRepository에서 모든 User들을 가져와서 크기가 맞는지 테스트`() = runTest {
        val userList = userRepository.getUsers()
        val expected = 10

        assertEquals(expected, userList.size)
    }

    @Test
    fun `UserRepository에서 username순으로 정렬되어 있는지 테스트`() = runTest {
        val userList = userRepository.getUsersTop10ByUserName()
        val expected = listOf(
            "Antonette",
            "Bret",
            "Delphine",
            "Elwyn.Skiles",
            "Kamren",
            "Karianne",
            "Leopoldo_Corkery",
            "Maxime_Nienow",
            "Moriah.Stanton",
            "Samantha"
        )
        val usernameList = userList.map { it.username }

        assertEquals(expected, usernameList)
    }
}