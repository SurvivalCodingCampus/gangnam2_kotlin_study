package com.sesac.practice.day14.user

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MockUserDataSourceImplTest {
    @Test
    fun `users_json 파일을 읽어서 User 리스트로 반환한다`() = runTest {
        // given
        val pathname = "data/users.json"
        val dataSource = MockUserDataSourceImpl(pathname)

        // when
        val users = dataSource.getUsers()

        // then
        assertEquals(10, users.size)
    }
}
