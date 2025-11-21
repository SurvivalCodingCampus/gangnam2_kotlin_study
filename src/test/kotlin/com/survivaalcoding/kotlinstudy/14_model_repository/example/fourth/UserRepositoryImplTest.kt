package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertContains
import kotlin.test.assertIs

class UserRepositoryImplTest {
    @Test
    fun `User 전체 데이터를 조회한다`() {
        // given
        val dataSize = 11
        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockUserDataSourceImpl(file)

        val repository = UserRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getUsers()

            // then
            assertIs<List<User>>(actual)
            assertEquals(dataSize, actual.size)
        }
    }

    @Test
    fun `10명의 오름차순 User를 조회한다`() {
        // given
        val dataSize = 10
        val expected = listOf(
            User(
                1L,
                "name1",
                "aaa",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                2L,
                "name2",
                "aba",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                5L,
                "name5",
                "abc",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                11L,
                "name11",
                "app",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                4L,
                "name4",
                "baa",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                6L,
                "name6",
                "ddd",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                10L,
                "name10",
                "ioi",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                7L,
                "name7",
                "kkk",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                9L,
                "name9",
                "que",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            ),
            User(
                3L,
                "name3",
                "zaa",
                "user1@gmail.com",
                Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
                "010-1111-2222",
                "https://url.com",
                Company("company", "unknown", "bs")
            )
        )
        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockUserDataSourceImpl(file)

        val repository = UserRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getUsersTop10ByUserName()

            // then
            assertIs<List<User>>(actual)
            assertEquals(dataSize, actual.size)
            assertEquals(expected ,actual)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/fourth/"
        private const val FILE_NAME = "users.json"
    }
}