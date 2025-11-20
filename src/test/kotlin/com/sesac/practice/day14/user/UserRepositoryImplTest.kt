package com.sesac.practice.day14.user

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {

    private val dataSource = MockUserDataSourceImpl()

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
}
