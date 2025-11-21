package com.neouul.sesac.`13-modelClass-repository`.albums

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class AlbumRepositoryImplTest {
    @Test
    fun `getAlbums(null)이 모든 데이터를 반환하는지 - Mocking`() = runBlocking {
        // given:
        // AlbumDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관없이
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<AlbumDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadAlbums() } returns listOf(
            Album(1, 11, "a"),
            Album(2, 12, "b"),
            Album(3, 13, "c"),
            Album(4, 14, "d"),
            Album(5, 15, "e"),
            Album(6, 16, "f"),
        )
        val albumRepository = AlbumRepositoryImpl(mockDataSource)

        // when:
        // getAlbums의 인자로 null을 전달하여 모든 데이터를 반환하도록 함
        val result = albumRepository.getAlbums(null)

        // then:
        // 6개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(1, result[0].userId)
        assertEquals(11, result[0].id)
        assertEquals("a", result[0].title)

        assertEquals(2, result[1].userId)
        assertEquals(12, result[1].id)
        assertEquals("b", result[1].title)

        assertEquals(3, result[2].userId)
        assertEquals(13, result[2].id)
        assertEquals("c", result[2].title)

        assertEquals(4, result[3].userId)
        assertEquals(14, result[3].id)
        assertEquals("d", result[3].title)

        assertEquals(5, result[4].userId)
        assertEquals(15, result[4].id)
        assertEquals("e", result[4].title)

        assertEquals(6, result[5].userId)
        assertEquals(16, result[5].id)
        assertEquals("f", result[5].title)
    }

    @Test
    fun `getAlbums(limit)가 상위 limit개의 데이터를 반환하는지 - Mocking`() = runBlocking {
        // given:
        val mockDataSource = mockk<AlbumDataSourceImpl>()
        coEvery { mockDataSource.loadAlbums() } returns listOf(
            Album(4, 14, "d"),
            Album(5, 15, "e"),
            Album(6, 16, "f"),
            Album(1, 11, "a"),
            Album(2, 12, "b"),
            Album(3, 13, "c"),
        )
        val albumRepository = AlbumRepositoryImpl(mockDataSource)

        // when:
        // getAlbums의 인자로 3을 전달하여 상위 3개의 데이터를 반환하도록 함
        val result = albumRepository.getAlbums(3)

        // then:
        // 3개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals(4, result[0].userId)
        assertEquals(14, result[0].id)
        assertEquals("d", result[0].title)

        assertEquals(5, result[1].userId)
        assertEquals(15, result[1].id)
        assertEquals("e", result[1].title)

        assertEquals(6, result[2].userId)
        assertEquals(16, result[2].id)
        assertEquals("f", result[2].title)
    }
}