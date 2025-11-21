package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class UserDataSourceTest {
    val userDataSource = MockUserDataSourceImpl(filename = "users.json")

    @Test
    fun `파일이 존재하는지 확인`() {
        val usersJson = this::class.java.classLoader.getResource("users.json")

        assertNotNull(usersJson, "users.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `User리스트를 불러오는지 테스트`() = runTest {
        val userList = userDataSource.getAllUsers()

        assertIs<List<User>>(userList)
    }

    @Test
    fun `User리스트 크기가 일치한지 테스트`() = runTest {
        val userList = userDataSource.getAllUsers()
        val expected = 10

        assertEquals(expected, userList.size)
    }

    @Test
    fun `User리스트 첫번째 객체가 일치한지 테스트`() = runTest {
        val expected = User(
            id = 1,
            name = "Leanne Graham",
            username = "Bret",
            email = "Sincere@april.biz",
            address = Address(
                street = "Kulas Light",
                suite = "Apt. 556",
                city = "Gwenborough",
                zipcode = "92998-3874",
                geo = Geo("-37.3159", "81.1496")
            ),
            phone = "1-770-736-8031 x56442",
            website = "hildegard.org",
            company = Company(
                name = "Romaguera-Crona",
                catchPhrase = "Multi-layered client-server neural-net",
                bs = "harness real-time e-markets"
            )
        )
        val userList = userDataSource.getAllUsers()
        val firstUser = userList.first()

        assertEquals(expected, firstUser)
    }

    @Test
    fun `User리스트 마지막 객체가 일치한지 테스트`() = runTest {
        val expected = User(
            id = 10,
            name = "Clementina DuBuque",
            username = "Moriah.Stanton",
            email = "Rey.Padberg@karina.biz",
            address = Address(
                street = "Kattie Turnpike",
                suite = "Suite 198",
                city = "Lebsackbury",
                zipcode = "31428-2261",
                geo = Geo("-38.2386", "57.2232")
            ),
            phone = "024-648-3804",
            website = "ambrose.net",
            company = Company(
                name = "Hoeger LLC",
                catchPhrase = "Centralized empowering task-force",
                bs = "target end-to-end models"
            )
        )
        val userList = userDataSource.getAllUsers()
        val lastUser = userList.last()

        assertEquals(expected, lastUser)
    }
}