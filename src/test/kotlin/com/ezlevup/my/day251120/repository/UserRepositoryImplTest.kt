package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.MockUserDataSourceImpl
import com.ezlevup.my.day251120.model.Address
import com.ezlevup.my.day251120.model.Company
import com.ezlevup.my.day251120.model.Geo
import com.ezlevup.my.day251120.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserRepositoryImplTest {
    @Test
    fun `UserRepositoryImpl 생성자`() {
        // given
        val userRepository = UserRepositoryImpl(MockUserDataSourceImpl())

        // when & then
        assertNotNull(userRepository)
    }


    @Test
    fun `UserRepositoryImpl getUsers() 확인`(): Unit = runBlocking {
        // given
        val users = listOf(
            User(
                id = 1, name = "lee1",
                username = "lee1", email = "lee1@naver.com",
                address = Address(
                    street = "lee-street1",
                    suite = "lee-suite1",
                    city = "Seoul",
                    zipcode = "12345",
                    geo = Geo(lat = "37.5665", lng = "126.9780")
                ),
                phone = "010-1111-1111",
                website = "lee1.com",
                company = Company(
                    name = "LeeCompany1",
                    catchPhrase = "First lee company",
                    bs = "lee-business-1"
                )
            ),
            User(
                id = 2, name = "lee2",
                username = "lee2", email = "lee2@naver.com",
                address = Address(
                    street = "lee-street2",
                    suite = "lee-suite2",
                    city = "Busan",
                    zipcode = "54321",
                    geo = Geo(lat = "35.1796", lng = "129.0756")
                ),
                phone = "010-2222-2222",
                website = "lee2.com",
                company = Company(
                    name = "LeeCompany2",
                    catchPhrase = "Second lee company",
                    bs = "lee-business-2"
                )
            )
        )
        val userRepository = UserRepositoryImpl(MockUserDataSourceImpl(users))

        // when
        val result = userRepository.getUsers()

        // then
        assertEquals(users.count(), result.count())
    }


    @Test
    fun `UserRepositoryImpl getUsersTop10ByUserName() 확인`(): Unit = runBlocking {
        // given
        val cities = listOf(
            "Seoul", "Busan", "Incheon", "Daegu", "Daejeon",
            "Gwangju", "Ulsan", "Suwon", "Goyang", "Seongnam"
        )

        val geoCoords = listOf(
            "37.5665" to "126.9780",
            "35.1796" to "129.0756",
            "37.4563" to "126.7052",
            "35.8714" to "128.6014",
            "36.3504" to "127.3845",
            "35.1595" to "126.8526",
            "35.5384" to "129.3114",
            "37.2636" to "127.0286",
            "37.6564" to "126.8350",
            "37.4449" to "127.1388"
        )

        val users = (1..10).map { i ->
            val randomIndex = (cities.indices).random()
            val (lat, lng) = geoCoords[randomIndex]

            User(
                id = i,
                name = "lee$i",
                username = "lee$i",
                email = "lee$i@naver.com",
                address = Address(
                    street = "lee-street$i",
                    suite = "lee-suite$i",
                    city = cities[randomIndex],
                    zipcode = "${10000 + i * 100}",
                    geo = Geo(lat = lat, lng = lng)
                ),
                phone = "010-${"%04d".format(i)}-${"%04d".format(i)}",
                website = "lee$i.com",
                company = Company(
                    name = "LeeCompany$i",
                    catchPhrase = when (i) {
                        1 -> "First lee company"
                        2 -> "Second lee company"
                        3 -> "Third lee company"
                        else -> "${i}th lee company"
                    },
                    bs = "lee-business-$i"
                )
            )
        }

        val userRepository = UserRepositoryImpl(MockUserDataSourceImpl(users))

        // when
        val result = userRepository.getUsersTop10ByUserName()

        // then
        assertEquals(users.count(), result.count())

        val orderUsers = users.sortedBy { it.username }
        orderUsers.forEachIndexed { index, user ->
            assertTrue(user.username == result[index].username)
        }
    }

}