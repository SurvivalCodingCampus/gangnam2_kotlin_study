package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class FileUserDataSourceImplTest {
    @Test
    fun `json 파일 데이터를 User로 역직렬화 할 수 있다`() {
        // given
        val jsonSize = 10

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = FileUserDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getUser()

            // then
            assertIs<List<User>>(actual)
            assertEquals(jsonSize, actual.size)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/fourth/"
        private const val FILE_NAME = "users.json"
    }
}