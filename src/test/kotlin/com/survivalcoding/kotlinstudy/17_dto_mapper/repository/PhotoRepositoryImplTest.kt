package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source.PhotoDataSource
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.PhotoDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.PhotoType
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    private val dataSource = mockk<PhotoDataSource>()
    private val repository = PhotoRepositoryImpl(dataSource)

    @Test
    fun `DTO가 모델 정상 변환`() = runTest {
        // given
        coEvery { dataSource.getPhotos() } returns listOf(
            PhotoDto(
                id = "10",
                type = "article",
                title = "Hello",
                content = "World",
                url = "http://test.com",
                caption = "test",
                createdAt = "2020-01-01"
            )
        )

        // when
        val result = repository.getPhotos()

        // then
        val photo = result.first()
        assertEquals(10, photo.id)
        assertEquals(PhotoType.ARTICLE, photo.type)
        assertEquals("Hello", photo.title)
        assertEquals("World", photo.content)
        assertEquals("http://test.com", photo.url)
        assertEquals("test", photo.caption)
        assertEquals(2020, photo.createdAt?.year)
    }

    @Test
    fun `type null - UNKNOWN`() = runTest {
        // given
        coEvery { dataSource.getPhotos() } returns listOf(
            PhotoDto(
                id = "5",
                type = null,
                title = "test",
                content = "content",
                url = null,
                caption = null,
                createdAt = "2020-01-01"
            )
        )

        // when
        val result = repository.getPhotos()

        // then
        assertEquals(PhotoType.UNKNOWN, result.first().type)
    }
}
