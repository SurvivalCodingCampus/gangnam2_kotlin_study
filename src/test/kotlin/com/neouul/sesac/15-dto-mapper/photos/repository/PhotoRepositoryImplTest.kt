package com.neouul.sesac.`15-dto-mapper`.photos.repository

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PhotoRepositoryImplTest {
    @Test
    fun `getPhotos 메서드 성공 - MockPhotoDataSourceImpl`() = runBlocking {
        // given
        // 생성자 디폴드값: MockPhotoDataSourceImpl 인스턴스
        val photoRepository: PhotoRepository = PhotoRepositoryImpl()

        // when
        val photos = photoRepository.getPhotos()

        // then
        assertEquals(6, photos.size)
    }
}