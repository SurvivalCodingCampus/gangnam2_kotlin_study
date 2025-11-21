package com.neouul.sesac.`12-datasource`

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class UserDataSourceImplTest {
    @Test
    fun `연습문제 3 - getUsers가 역직렬화하여 List User를 잘 반환하는가`() = runBlocking {
        // given
        val userDataSourceImpl = UserDataSourceImpl()

        // when
        val users = userDataSourceImpl.getUsers()

        // then
        users.forEach {
            assertTrue(it is User)
            assertTrue(it.id is Int)
            assertTrue(it.name is String)
            assertTrue(it.username is String)
            assertTrue(it.email is String)

            assertTrue(it.address is Address)
            assertTrue(it.address.street is String)
            assertTrue(it.address.suite is String)
            assertTrue(it.address.city is String)
            assertTrue(it.address.zipcode is String)

            assertTrue(it.address.geo is Geo)
            assertTrue(it.address.geo.lat is String)
            assertTrue(it.address.geo.lng is String)

            assertTrue(it.phone is String)
            assertTrue(it.website is String)

            assertTrue(it.company is Company)
            assertTrue(it.company.name is String)
            assertTrue(it.company.catchPhrase is String)
            assertTrue(it.company.bs is String)
        }
    }
}