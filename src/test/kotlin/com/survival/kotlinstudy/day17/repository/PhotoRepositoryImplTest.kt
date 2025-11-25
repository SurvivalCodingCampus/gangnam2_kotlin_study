package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.datasource.MockPhotoDataSourceImpl
import com.survival.kotlinstudy.day17.model.PhotoType
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals


class PhotoRepositoryImplTest {
    private val dataSource = MockPhotoDataSourceImpl()

    private val repository = PhotoRepositoryImpl(dataSource)


    @Test
    fun `getPhotos() 함수 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(6, photos.size)

    }

    @Test
    fun `getPhotos()시 type 변환 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[0].type, PhotoType.ARTICLE)
        assertEquals(photos[1].type, PhotoType.IMAGE)
        assertEquals(photos[2].type, PhotoType.VIDEO)
        assertEquals(photos[3].type, PhotoType.ARTICLE)
        assertEquals(photos[4].type, PhotoType.UNKNOWN)
        assertEquals(photos[5].type, PhotoType.UNKNOWN)

    }

    @Test
    fun `getPhotos()시 createdAt 변환 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[0].createdAt, LocalDate.of(2020, 1, 1))
        assertEquals(photos[1].createdAt, LocalDate.of(2020, 2, 2))
        assertEquals(photos[2].createdAt, LocalDate.of(2020, 3, 3))
        assertEquals(photos[3].createdAt, LocalDate.of(2020, 1, 1))
        assertEquals(photos[4].createdAt, LocalDate.of(2020, 2, 2))
        assertEquals(photos[5].createdAt, LocalDate.of(2020, 3, 3))

    }

    @Test
    fun `getPhotos()시 caption이 없는 경우 빈 값 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[0].caption, "")
        assertEquals(photos[3].caption, "")

    }

    @Test
    fun `getPhotos()시 content가 없는 경우 빈 값 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[1].content, "")
        assertEquals(photos[2].content, "")
        assertEquals(photos[4].content, "")
        assertEquals(photos[5].content, "")

    }

    @Test
    fun `getPhotos()시 title이 없는 경우 빈 값 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[1].title, "")
        assertEquals(photos[2].title, "")
        assertEquals(photos[4].title, "")
        assertEquals(photos[5].title, "")

    }

    @Test
    fun `getPhotos()시 url이 없는 경우 빈 값 테스트`() = runTest {
        val photos = repository.getPhotos()

        assertEquals(photos[0].url, "")
        assertEquals(photos[3].url, "")

    }
}