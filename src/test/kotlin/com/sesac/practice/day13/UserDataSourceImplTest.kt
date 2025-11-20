package com.sesac.practice.day13

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class UserDataSourceImplTest {
    @Test
    fun `users_json 파일을 읽어서 User 객체 리스트로 변환한다`() = runTest {
        // given
        val filename = "data/users.json"
        val dataSource = UserDataSourceImpl(filename)

        // when
        val users = dataSource.getUsers()

        // then
        assertEquals(10, users.size)
    }
}
