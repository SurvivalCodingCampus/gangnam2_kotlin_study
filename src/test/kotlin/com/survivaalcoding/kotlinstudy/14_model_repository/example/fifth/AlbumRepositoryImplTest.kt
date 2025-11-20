package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertIs

class AlbumRepositoryImplTest {
    @Test
    fun `인수를 지정하지 않으면 Album 전체 데이터를 조회한다`() {
        // given
        val expected = 5

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockAlbumDataSourceImpl(file)
        val repository = AlbumRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getAlbums()

            // then
            assertIs<List<Album>>(actual)
            assertEquals(expected, actual.size)
        }
    }

    @Test
    fun `limit이 2면 2개의 Album 데이터를 조회한다`() {
        // given
        val expected = 2

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockAlbumDataSourceImpl(file)
        val repository = AlbumRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getAlbums(expected)

            // then
            assertIs<List<Album>>(actual)
            assertEquals(expected, actual.size)
        }
    }

    @Test
    fun `limit 수가 전체 데이터보다 많으면 Album 전체 데이터 수만큼만 조회된다`() {
        // given
        val limit = Int.MAX_VALUE
        val expected = 5

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockAlbumDataSourceImpl(file)
        val repository = AlbumRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = repository.getAlbums(limit)

            // then
            assertIs<List<Album>>(actual)
            assertEquals(expected, actual.size)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/fifth/"
        private const val FILE_NAME = "albums.json"
    }
}