package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class MockAlbumDataSourceImplTest {
    @Test
    fun `Album 리스트를 가져올 수 있다`() {
        // given
        val jsonSize = 5
        val expected = listOf(
            Album(1L, 1L, "title1"),
            Album(2L, 1L, "title2"),
            Album(3L, 2L, "title3"),
            Album(4L, 3L, "title4"),
            Album(5L, 2L, "title5")
        )

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockAlbumDataSourceImpl(file)

        runBlocking {
            // when
            val actual = mockDataSource.getAlbum()

            // then
            assertEquals(jsonSize, actual.size)
            assertEquals(expected, actual)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/fifth/"
        private const val FILE_NAME = "albums.json"
    }
}