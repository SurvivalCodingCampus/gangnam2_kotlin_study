package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Photo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class FilePhotoDataSourceImplTest {
    companion object {
        private const val PHOTOS_SIZE = 5000
    }

    private val dataSource = MockPhotoDataSourceImpl()

    @Test
    fun `리스트 확인 - 리스트 모두 불러보기`(): Unit = runBlocking {
        // when
        val photos = dataSource.getPhotos()

        // then
        assertTrue(photos.isNotEmpty())
        assertEquals(PHOTOS_SIZE, photos.size)
        assertIs<List<Photo>>(photos)
    }

    @Test
    fun `역직렬화 - 타입 체크`() = runBlocking {
        // when
        val photos = dataSource.getPhotos()

        // then
        photos.forEach {
            assertTrue { it is Photo }
            assertTrue { it.id is Int }
            assertTrue { it.albumId is Int }
            assertTrue { it.title is String }
            assertTrue { it.url is String }
            assertTrue { it.thumbnailUrl is String }
        }
    }
}