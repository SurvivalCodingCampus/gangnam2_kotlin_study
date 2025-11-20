package com.neouul.sesac.`13-modelClass-repository`.photos

import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import io.mockk.mockk

class PhotoRepositoryImplTest {
    @Test
    fun `getPhotos가 특정 albumId를 가진 데이터만 반환하는지 - PhotoDataSourceImpl`() = runBlocking {
        // given:
        // photos.json에서 데이터 들고오는 PhotoDataSourceImpl 인스턴스를
        // PhotoRepositoryImpl의 생성자에 전달하기
        val photoDataSource = PhotoDataSourceImpl()     // 경로가 디폴트값으로 설정되어 있음
        val photoRepository = PhotoRepositoryImpl(photoDataSource)

        // when: albumId == 1인 데이터만 받기
        val result = photoRepository.getPhotos(1)

        // then: 결과 리스트의 모든 인스턴스의 albumId 값은 1이다
        result.forEach {
            assertEquals(1, it.albumId)
        }
    }

    @Test
    fun `getPhotos가 특정 albumId를 가진 데이터만 반환하는지 - Mocking`() = runBlocking {
        // given:
        // PhotoDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관하지 않고
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<PhotoDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadPhotos() } returns listOf(
            Photo(1, 11, "a", "https://a", "https://a.com"),
            Photo(2, 12, "b", "https://b", "https://b.com"),
            Photo(3, 13, "c", "https://c", "https://c.com"),
            Photo(1, 14, "d", "https://d", "https://d.com"),
            Photo(1, 15, "e", "https://e", "https://e.com"),
            Photo(4, 16, "f", "https://f", "https://f.com"),
        )
        val photoRepository = PhotoRepositoryImpl(mockDataSource)

        // when: albumId == 1인 데이터만 받기
        val result = photoRepository.getPhotos(1)

        // then: 결과 리스트의 모든 인스턴스의 albumId 값은 1이다
        result.forEach {
            assertEquals(1, it.albumId)
        }

        // 3개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(1, result[0].albumId)
        assertEquals(11, result[0].id)
        assertEquals("a", result[0].title)
        assertEquals("https://a", result[0].url)
        assertEquals("https://a.com", result[0].thumbnailUrl)

        assertEquals(1, result[1].albumId)
        assertEquals(14, result[1].id)
        assertEquals("d", result[1].title)
        assertEquals("https://d", result[1].url)
        assertEquals("https://d.com", result[1].thumbnailUrl)

        assertEquals(1, result[2].albumId)
        assertEquals(15, result[2].id)
        assertEquals("e", result[2].title)
        assertEquals("https://e", result[2].url)
        assertEquals("https://e.com", result[2].thumbnailUrl)
    }
}