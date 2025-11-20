package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class PhotoRepositoryImplTest {
    @Test
    fun `albumId에 해당하는 Photo 리스트를 가져올 수 있다`() {
        // given
        val albumId = 1L
        val albumIdSize = 1

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockPhotoDataSourceImpl(file)
        val photoRepository = PhotoRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = photoRepository.getPhotos(albumId)

            // then
            assertIs<List<Photo>>(actual)
            assertEquals(albumIdSize, actual.size)
        }

    }

    @Test
    fun `존재하지 않는 albumId는 빈 리스트를 가져온다`() {
        // given
        val albumId = Long.MAX_VALUE
        val albumSize = 0

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockPhotoDataSourceImpl(file)
        val photoRepository = PhotoRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual = photoRepository.getPhotos(albumId)

            // then
            assertEquals(albumSize, actual.size)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/second/"
        private const val FILE_NAME = "photos.json"
    }
}