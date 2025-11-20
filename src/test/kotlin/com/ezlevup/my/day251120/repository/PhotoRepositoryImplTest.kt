package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.MockPhotoDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertNotNull

class PhotoRepositoryImplTest {
    @Test
    fun `PhotoRepositoryImpl 생성자`() {
        // given
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        // when & then
        assertNotNull(photoRepository)
    }

    @Test
    fun `PhotoRepositoryImpl getPhotos 호출`(): Unit = runBlocking {
        // given
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        // when
        val photos = photoRepository.getPhotos(1)

        // then
        assertNotNull(photos)
    }
}