package com.luca.kotlinstudy._15_model_repository.repository.user

import com.luca.kotlinstudy._15_model_repository.dataSource.user.MockUserDatasourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class UserRepositoryImplTest {

    private val mockDataSource = MockUserDatasourceImpl()
    private val repository = UserRepositoryImpl(mockDataSource)

    @Test
    fun `getUsers 는 전체 유저 목록을 반환한다`() = runBlocking {
        val result = repository.getUsers()

        assertTrue(result.isNotEmpty())
    }

    @Test
    fun `getUsersTop10ByUserName 은 username 기준 오름차순 정렬되어 있다`() = runBlocking {
        val result = repository.getUsersTop10ByUserName()

        val usernames = result.map { it.username }
        val sorted = usernames.sorted()

        assertEquals(sorted, usernames)   // 정렬되어 있는지 확인
        assertTrue(result.size <= 10)     // 최대 10개까지만
    }
}
