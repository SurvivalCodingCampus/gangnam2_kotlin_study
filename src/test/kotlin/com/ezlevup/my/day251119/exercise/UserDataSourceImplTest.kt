package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertNotNull

class UserDataSourceImplTest {
    @Test
    fun `UserData 생성자`() {
        // given
        val userDataSource = UserDataSourceImpl()

        // when & then
        assertNotNull(userDataSource)
    }

    @Test
    fun `UserData 데이터 가지고 오기`(): Unit = runBlocking {
        // given
        val userData = UserDataSourceImpl()

        // when
        val users = userData.getUsers()

        // then
        assertNotNull(users)
    }

    @Test
    fun `UserData 데이터 불량이 있는지`(): Unit = runBlocking {
        // given
        val userData = UserDataSourceImpl()

        // when
        val users = userData.getUsers()
        val invalidCount: Int = users.count { it ->
            it.id == 0L
                    || it.name.isNullOrEmpty()
                    || it.username.isNullOrEmpty()
                    || it.email.isNullOrEmpty()
                    || it.address == null
                    || it.phone.isNullOrEmpty()
                    || it.website.isNullOrEmpty()
                    || it.company == null
        }

        // then
        assertEquals(0, invalidCount)
    }
}