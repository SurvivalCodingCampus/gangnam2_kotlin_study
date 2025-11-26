package com.sesac.practice.day16.repository

import com.sesac.practice.day16.datasource.MockPhotoDataSourceImpl
import com.sesac.practice.day16.model.PhotoType
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class PhotoRepositoryImplTest {

    private val dataSource = MockPhotoDataSourceImpl()
    private val repository = PhotoRepositoryImpl(dataSource)

    @Test
    fun `Photo 리스트를 가져온다`() = runTest {
        // given // when
        val photos = repository.getPhotos()

        // then
        assertEquals(6, photos.size)

        val photo1 = photos[0]
        assertEquals(1L, photo1.id)
        assertEquals(PhotoType.ARTICLE, photo1.type)
        assertEquals(LocalDate.of(2020, 1, 1), photo1.createdAt)
        assertNotNull(photo1.title)
        assertNull(photo1.url)

        val photo2 = photos[1]
        assertEquals(2L, photo2.id)
        assertEquals(PhotoType.IMAGE, photo2.type)
        assertEquals(LocalDate.of(2020, 2, 2), photo2.createdAt)
        assertEquals("제목 없음", photo2.title)
        assertNotNull(photo2.url)

        val photo3 = photos[2]
        assertEquals(3L, photo3.id)
        assertEquals(PhotoType.VIDEO, photo3.type)
        assertEquals(LocalDate.of(2020, 3, 3), photo3.createdAt)
        assertEquals("제목 없음", photo3.title)
        assertNotNull(photo3.url)

        val photo4 = photos[3]
        assertEquals(1L, photo4.id)

        val photo5 = photos[4]
        assertEquals(2L, photo2.id)
        assertEquals(PhotoType.UNKNOWN, photo5.type)

        val photo6 = photos[5]
        assertEquals(3L, photo3.id)
        assertEquals(PhotoType.UNKNOWN, photo6.type)
    }
}
