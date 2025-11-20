package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source


import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.user.FileUserDataSourceImpl
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Address
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Company
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Geo
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class FileUserDataSourceImplTest {
    companion object {
        private const val USERS_SIZE = 10
    }

    private val dataSource = FileUserDataSourceImpl()

    @Test
    fun `리스트 확인 - 리스트 모두 불러보기`(): Unit = runBlocking {
        // when
        val users = dataSource.getUsers()

        // then
        assertTrue(users.isNotEmpty())
        assertEquals(USERS_SIZE, users.size)
        assertIs<List<User>>(users)
    }

    @Test
    fun `역직렬화 - 타입 체크`() = runBlocking {
        // when
        val users = dataSource.getUsers()

        // then
        users.forEach {
            assertTrue { it is User }
            assertTrue { it.id is Int }
            assertTrue { it.name is String }
            assertTrue { it.username is String }
            assertTrue { it.email is String }
            assertTrue { it.address is Address }
            assertTrue { it.address.street is String }
            assertTrue { it.address.suite is String }
            assertTrue { it.address.city is String }
            assertTrue { it.address.zipcode is String }
            assertTrue { it.address.geo is Geo }
            assertTrue { it.address.geo.lat is String }
            assertTrue { it.address.geo.lng is String }
            assertTrue { it.phone is String }
            assertTrue { it.website is String }
            assertTrue { it.company is Company }
            assertTrue { it.company.name is String }
            assertTrue { it.company.catchPhrase is String }
            assertTrue { it.company.bs is String }
        }
    }
}