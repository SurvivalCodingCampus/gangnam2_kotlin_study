package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertIs

class UserDataSourceImplTest {
    @Test
    fun `json 데이터를 역직렬화해서 User 객체로 가져온다`() {
        // given
        val id = 1
        val name = "Leanne Graham"
        val username = "Bret"
        val email = "Sincere@april.biz"

        val street = "Kulas Light"
        val suite = "Apt. 556"
        val city = "Gwenborough"
        val zipcode = "92998-3874"

        val lat = "-37.3159"
        val lng = "81.1496"
        val geo = getGeo(lat, lng)
        val address = getAddress(street, suite, city, zipcode, geo)

        val phone = "1-770-736-8031 x56442"
        val website = "hildegard.org"

        val companyName = "Romaguera-Crona"
        val catchPhrase = "Multi-layered client-server neural-net"
        val bs = "harness real-time e-markets"
        val company = getCompany(companyName, catchPhrase, bs)

        val user = User(id, name, username, email, address, phone, website, company)

        runBlocking {
            // when
            val actual = UserDataSourceImpl().getUsers()

            // then
            assertIs<List<User>>(actual)
            assertEquals(actual.size, 10)
            assertContains(actual, user)
        }
    }
}

private fun getGeo(lat: String, lng: String): Geo = Geo(lat, lng)

private fun getAddress(
    street: String,
    suite: String,
    city: String,
    zipcode: String,
    geo: Geo
): Address = Address(street, suite, city, zipcode, geo)

private fun getCompany(
    companyName: String,
    catchPhrase: String,
    bs: String
): Company = Company(companyName, catchPhrase, bs)
