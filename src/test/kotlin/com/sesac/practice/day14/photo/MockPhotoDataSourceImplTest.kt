package com.sesac.practice.day14.photo

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MockPhotoDataSourceImplTest {
    @Test
    fun `photos_json 파일을 읽어서 Photo 리스트로 반환한다`() = runTest {
        // given
        val pathname = "data/photos.json"
        val dataSource = MockPhotoDataSourceImpl(pathname)

        // when
        val photos = dataSource.getPhotos()

        // then
        assertEquals(5000, photos.size)
    }
}
