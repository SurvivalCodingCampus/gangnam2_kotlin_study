package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class MockUserDataSourceImplTest {
    @Test
    fun `User 리스트를 가져올 수 있다`() {
        // given
        val dataSize = 11
        val expected = getUsers()

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockUserDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getUser()

            // then
            assertIs<List<User>>(actual)
            assertEquals(dataSize, actual.size)
            assertEquals(expected, actual)
        }
    }

    private fun getUsers() = listOf(
        User(
            1L,
            "name1",
            "aaa",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            2L,
            "name2",
            "aba",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            3L,
            "name3",
            "zaa",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            4L,
            "name4",
            "baa",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            5L,
            "name5",
            "abc",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            6L,
            "name6",
            "ddd",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            7L,
            "name7",
            "kkk",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            8L,
            "name8",
            "zya",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            9L,
            "name9",
            "que",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            10L,
            "name10",
            "ioi",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        ),
        User(
            11L,
            "name11",
            "app",
            "user1@gmail.com",
            getAddress(),
            "010-1111-2222",
            "https://url.com",
            getCompany()
        )
    )

    private fun getAddress(): Address = Address("street", "suite", "city", "01234", Geo("12.23", "33.44"))

    private fun getCompany(): Company = Company("company", "unknown", "bs")

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/fourth/"
        private const val FILE_NAME = "users.json"
    }
}