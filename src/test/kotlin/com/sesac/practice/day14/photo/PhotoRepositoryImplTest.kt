package com.sesac.practice.day14.photo

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoRepositoryImplTest {

    private val dataSource = MockPhotoDataSourceImpl()

    @Test
    fun `albumId가 일치하는 Photo 리스트를 가져온다`() = runTest {
        // given
        val repository = PhotoRepositoryImpl(dataSource)

        // when
        val albumId = 1
        val photos = repository.getPhotos(albumId)

        // then
        assertEquals(2, photos.size)
    }
}
