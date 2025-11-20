package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.photo.MockPhotoDataSourceImpl
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository.photo.PhotoRepositoryImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PhotoRepositoryImplTest {

    companion object {
        private const val ALBUM_ID = 1
        private const val MOCK_PHOTO_SIZE = 5
        private const val NOT_EXIST_ALBUM_ID = 999
    }

    private val repo = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

    @Test
    fun `albumId로 사진 필터링`() = runBlocking {
        val result = repo.getPhotos(ALBUM_ID)

        assertTrue(result.all { it.albumId == ALBUM_ID })
        assertEquals(MOCK_PHOTO_SIZE, result.size)
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun `존재하지 않는 albumId - 빈 리스트 반환`() = runBlocking {
        val result = repo.getPhotos(NOT_EXIST_ALBUM_ID)

        assertTrue(result.isEmpty())
    }
}
