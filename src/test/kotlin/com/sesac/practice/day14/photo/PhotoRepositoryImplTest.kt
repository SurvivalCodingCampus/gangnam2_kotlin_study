package com.sesac.practice.day14.photo

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoRepositoryImplTest {
    @Test
    fun `albumId가 일치하는 Photo 리스트를 가져온다`() = runTest {
        // given
        val repository = PhotoRepositoryImpl(
            object : PhotoDataSource {
                override suspend fun getPhotos(): List<Photo> {
                    return listOf(
                        Photo(1, 1, "title1", "url1", "thumbnailUrl1"),
                        Photo(1, 2, "title2", "url2", "thumbnailUrl2"),
                        Photo(2, 1, "title3", "url3", "thumbnailUrl3"),
                        Photo(2, 2, "title4", "url4", "thumbnailUrl4"),
                    )
                }
            },
        )

        // when
        val albumId = 1
        val photos = repository.getPhotos(albumId)

        // then
        assertEquals(2, photos.size)
    }
}
