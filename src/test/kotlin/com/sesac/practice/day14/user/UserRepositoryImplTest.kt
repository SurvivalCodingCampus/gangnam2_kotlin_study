package com.sesac.practice.day14.user

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {

    private val dataSource = object : UserDataSource {
        override suspend fun getUsers(): List<User> {
            return listOf(
                createUser(1, "name1", "F"),
                createUser(2, "name2", "K"),
                createUser(3, "name3", "A"),
                createUser(4, "name4", "G"),
                createUser(5, "name5", "B"),
                createUser(6, "name6", "H"),
                createUser(7, "name7", "C"),
                createUser(8, "name8", "I"),
                createUser(9, "name9", "D"),
                createUser(10, "name10", "J"),
                createUser(11, "name11", "E"),
            )
        }
    }

    @Test
    fun `User 리스트를 가져온다`() = runTest {
        // given
        val repository = UserRepositoryImpl(dataSource)

        // when
        val users = repository.getUsers()

        // then
        assertEquals(11, users.size)
    }

    @Test
    fun `이름으로 정렬 후 상위 10개를 가져온다`() = runTest {
        // given
        val repository = UserRepositoryImpl(dataSource)

        // when
        val users = repository.getUsersTop10ByUserName()

        // then
        assertEquals(10, users.size)
        assertEquals(
            listOf(
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            ),
            users.map { it.username },
        )
    }

    private fun createUser(id: Long, name: String, username: String): User {
        return User(
            id,
            name,
            username,
            "email",
            Address("street", "suite", "city", "zipcode", Geo("lat", "lng")),
            "phone",
            "website",
            Company("name", "catchPhrase", "bs"),
        )
    }
}
