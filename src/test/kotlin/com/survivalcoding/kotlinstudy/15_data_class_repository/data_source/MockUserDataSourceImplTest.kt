package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.User
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MockUserDataSourceImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 3
    }

    private val dataSource = MockUserDataSourceImpl()

    @Test
    fun `User 데이터 - 리스트 검사`(): Unit = runBlocking {
        // when
        val users = dataSource.getUsers()

        // then
        assertTrue(users.isNotEmpty())
        assertEquals(MOCK_DATA_SIZE, users.size)
        assertIs<List<User>>(users)
    }

    @Test
    fun `User 데이터 - 필드 타입 검사`() = runBlocking {
        // when
        val users = dataSource.getUsers()

        // then
        users.forEach { user ->
            assertTrue(user.id is Int)
            assertTrue(user.name is String)
            assertTrue(user.username is String)
            assertTrue(user.email is String)
            assertTrue(user.phone is String)
            assertTrue(user.website is String)

            // Address
            assertTrue(user.address.street is String)
            assertTrue(user.address.suite is String)
            assertTrue(user.address.city is String)
            assertTrue(user.address.zipcode is String)

            // Geo
            assertTrue(user.address.geo.lat is String)
            assertTrue(user.address.geo.lng is String)

            // Company
            assertTrue(user.company.name is String)
            assertTrue(user.company.catchPhrase is String)
            assertTrue(user.company.bs is String)
        }
    }
}
