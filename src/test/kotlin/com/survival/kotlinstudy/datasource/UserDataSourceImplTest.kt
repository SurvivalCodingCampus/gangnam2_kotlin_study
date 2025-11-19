package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertIs

class UserDataSourceImplTest {
    @Test
    fun `Json으로 UserList 생성 테스트`(): Unit = runBlocking {
        // given (준비)
        val userDataSourceImpl = UserDataSourceImpl()


        // when (실행)
        val data: List<User> = userDataSourceImpl.getUsers()

        // then (검증)
        assertIs<List<User>>(data)
        assertIs<Address>(data[0].address)
        assertIs<Company>(data[0].company)
    }
}