package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.repository

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.data_source.MockPhotoDataSourceImpl
import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.model.PhotoType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    private val mockDataSource = MockPhotoDataSourceImpl()
    private val repository = PhotoRepositoryImpl(mockDataSource)

    @Test
    fun `데이터를 잘 가져오는지 확인`() = runBlocking {
        val photos = repository.getPhotos()

        val expectedSize = 3

        val expectedFirstId = 1
        val expectedFirstType = PhotoType.Article
        val expectedFirstTitle = "This is an article"

        val expectedSecondId = 2
        val expectedSecondUrl = "https://example.com/image.jpg"

        val expectedThirdId = 3
        val expectedThirdUrl = "https://example.com/video.mp4"

        assertEquals(expectedSize, photos.size)

        val first = photos[0]
        assertEquals(expectedFirstId, first.id)
        assertEquals(expectedFirstType, first.type)
        assertEquals(expectedFirstTitle, first.title)

        val second = photos[1]
        assertEquals(expectedSecondId, second.id)
        assertEquals(expectedSecondUrl, second.url)

        val third = photos[2]
        assertEquals(expectedThirdId, third.id)
        assertEquals(expectedThirdUrl, third.url)
    }

    @Test
    fun `id로 단일 데이터를 잘 가져오는지 확인`() = runBlocking {
        val expectedId = 2
        val expectedType = PhotoType.Unknown
        val expectedUrl = "https://example.com/image.jpg"

        val photo = repository.getPhoto(expectedId)

        assertEquals(expectedId, photo.id)
        assertEquals(expectedType, photo.type)
        assertEquals(expectedUrl, photo.url)
    }
}





