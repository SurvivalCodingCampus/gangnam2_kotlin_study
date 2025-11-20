package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first.CommentRepositoryImpl
import com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first.MockCommentDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class PhotoRepositoryImplTest {
    @Test
    fun `albumId에 해당하는 Photo 리스트를 가져올 수 있다`() {
        // given
        val albumId1 = 1L
        val albumIdSize1 = 50

        val albumId2 = 100L
        val albumIdSize2 = 50

        val file = File("${DIR_PATH}${FILE_NAME}")
        val mockDataSource = MockPhotoDataSourceImpl(file)
        val photoRepository = PhotoRepositoryImpl(mockDataSource)

        runBlocking {
            // when
            val actual1 = photoRepository.getPhotos(albumId1)
            val actual2 = photoRepository.getPhotos(albumId2)

            // then
            assertEquals(albumIdSize1, actual1.size)
            assertEquals(albumIdSize2, actual2.size)
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
        private const val DIR_PATH = "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/second/"
        private const val FILE_NAME = "photos.json"
    }
}