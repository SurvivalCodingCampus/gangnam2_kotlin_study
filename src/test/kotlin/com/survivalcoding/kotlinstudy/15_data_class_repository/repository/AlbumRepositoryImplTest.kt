package com.survivalcoding.kotlinstudy.`15_data_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source.MockAlbumDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {

    companion object {
        private const val TOTAL_ALBUM_SIZE = 5
    }

    private val repo = AlbumRepositoryImpl(MockAlbumDataSourceImpl())

    @Test
    fun `limit null - 전체 앨범 반환`() = runBlocking {
        // when
        val result = repo.getAlbums(limit = null)

        // then
        assertEquals(TOTAL_ALBUM_SIZE, result.size)
    }

    @Test
    fun `limit보다 적은경우 - 전체 반환`() = runBlocking {
        // when
        val result = repo.getAlbums(limit = 10)

        // then
        assertEquals(TOTAL_ALBUM_SIZE, result.size)
    }

    @Test
    fun `limit만큼 앨범 반환`() = runBlocking {
        // when
        val result = repo.getAlbums(limit = 3)

        // then
        assertEquals(3, result.size)
    }

    @Test
    fun `limit이 0이면 빈 리스트`() = runBlocking {
        // when
        val result = repo.getAlbums(limit = 0)

        // then
        assertEquals(0, result.size)
    }
}
