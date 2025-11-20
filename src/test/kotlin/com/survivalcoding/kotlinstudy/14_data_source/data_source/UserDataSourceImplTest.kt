package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class UserDataSourceImplTest {
    companion object {
        private val dataSource = UserDataSourceImpl()
        private const val USERS_SIZE = 10

        private const val USER_1_ID = 1
        private const val USER_1_NAME = "Leanne Graham"
        private const val USER_1_USERNAME = "Bret"
        private const val USER_1_EMAIL = "Sincere@april.biz"

        private const val USER_1_STREET = "Kulas Light"
        private const val USER_1_SUITE = "Apt. 556"
        private const val USER_1_CITY = "Gwenborough"
        private const val USER_1_ZIPCODE = "92998-3874"

        private const val USER_1_LAT = "-37.3159"
        private const val USER_1_LNG = "81.1496"

        private const val USER_1_COMPANY_NAME = "Romaguera-Crona"
        private const val USER_1_COMPANY_PHRASE = "Multi-layered client-server neural-net"
        private const val USER_1_COMPANY_BS = "harness real-time e-markets"
    }

    @Test
    fun `Users 역직렬화 성공`() = runBlocking {
        // when
        val users = dataSource.getUsers()

        // then
        assertIs<List<User>>(users)
        assertEquals(USERS_SIZE, users.size)
    }

    @Test
    fun `Users 리스트 역직렬화 확인`() = runBlocking {
        // given
        val users = dataSource.getUsers()

        // when
        val user = users[0]

        // then
        assertEquals(USER_1_ID, user.id)
        assertEquals(USER_1_NAME, user.name)
        assertEquals(USER_1_USERNAME, user.username)
        assertEquals(USER_1_EMAIL, user.email)

        assertEquals(USER_1_STREET, user.address.street)
        assertEquals(USER_1_SUITE, user.address.suite)
        assertEquals(USER_1_CITY, user.address.city)
        assertEquals(USER_1_ZIPCODE, user.address.zipcode)

        assertEquals(USER_1_LAT, user.address.geo.lat)
        assertEquals(USER_1_LNG, user.address.geo.lng)

        assertEquals(USER_1_COMPANY_NAME, user.company.name)
        assertEquals(USER_1_COMPANY_PHRASE, user.company.catchPhrase)
        assertEquals(USER_1_COMPANY_BS, user.company.bs)
    }

    @Test
    fun `랜덤 사용자 역직렬화 검증`() = runBlocking {
        // given
        val users = dataSource.getUsers()

        // when
        val randomUser = users.random() // 랜덤 1명

        // then
        assertNotNull(randomUser.id)
        assertTrue(randomUser.name.isNotBlank())
        assertTrue(randomUser.username.isNotBlank())
        assertTrue(randomUser.email.isNotBlank())

        assertNotNull(randomUser.address)
        assertTrue(randomUser.address.street.isNotBlank())
        assertTrue(randomUser.address.city.isNotBlank())

        assertNotNull(randomUser.address.geo.lat)
        assertNotNull(randomUser.address.geo.lng)

        assertTrue(randomUser.company.name.isNotBlank())
        assertTrue(randomUser.company.catchPhrase.isNotBlank())
        assertTrue(randomUser.company.bs.isNotBlank())
    }
}