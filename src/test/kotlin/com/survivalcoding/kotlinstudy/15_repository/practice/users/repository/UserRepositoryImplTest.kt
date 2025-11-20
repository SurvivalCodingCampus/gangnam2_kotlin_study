package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.data_source.UserDataSource
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserRepositoryImplTest {

    private val dataSource: UserDataSource = MockUserDataSourceImpl()
    private val repository: UserRepository = UserRepositoryImpl(dataSource)

    @Test
    fun `데이터를 잘 가져오는지 확인`() = runBlocking {
        val result = repository.getUser()

        assertEquals(12, result.size)
    }

    @Test
    fun `이름 기준 10명을 가져오는지 확인`() = runBlocking {
        val result = repository.getUserTop10ByUserName()

        val expected = listOf(
            "Anna",
            "Bella",
            "Chris",
            "David",
            "Emma",
            "Frank",
            "Grace",
            "Henry",
            "Ivy",
            "Jack"
        )

        assertEquals(10, result.size)
        assertEquals(expected, result.map { it.name })
    }
}
