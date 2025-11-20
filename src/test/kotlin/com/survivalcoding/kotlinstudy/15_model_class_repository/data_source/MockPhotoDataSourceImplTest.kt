package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Photo
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MockPhotoDataSourceImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 5
    }

    private val dataSource = MockPhotoDataSourceImpl()

    @Test
    fun `Photo mock 데이터 - 리스트 검사`(): Unit = runBlocking {
        // when
        val photos = dataSource.getPhotos()

        // then
        assertTrue(photos.isNotEmpty())
        assertEquals(MOCK_DATA_SIZE, photos.size)
        assertIs<List<Photo>>(photos)
    }

    @Test
    fun `Photo mock 데이터 - 필드 타입 검사`() = runBlocking {
        // when
        val photos = dataSource.getPhotos()

        // then
        photos.forEach { photo ->
            assertTrue(photo is Photo)
            assertTrue(photo.albumId is Int)
            assertTrue(photo.id is Int)
            assertTrue(photo.title is String)
            assertTrue(photo.url is String)
            assertTrue(photo.thumbnailUrl is String)
        }
    }
}
