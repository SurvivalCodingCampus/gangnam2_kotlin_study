package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class MockPhotoDataSourceImplTest {
    @Test
    fun `Photo 리스트를 가져올 수 있다`() {
        // given
        val jsonSize = 2
        val expected = listOf(
            Photo(1L, 1L, "title1", "https://url1.com", "https://thubmail1.com"),
            Photo(2L, 2L, "title2", "https://url2.com", "https://thubmail2.com")
        )

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockPhotoDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getPhoto()

            // then
            assertIs<List<Photo>>(actual)
            assertEquals(jsonSize, actual.size)
            assertEquals(expected, actual)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/second/"
        private const val FILE_NAME = "photos.json"
    }
}