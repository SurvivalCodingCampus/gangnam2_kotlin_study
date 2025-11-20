package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.data_source.MockAlbumDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {

    private val dataSource = MockAlbumDataSourceImpl()
    private val repository = AlbumRepositoryImpl(dataSource)

    @Test
    fun `limit가 null이면 전부 가져오는지 확인`() = runBlocking {
        val result = repository.getAlbums(limit = null)

        assertEquals(3, result.size)
    }

    @Test
    fun `limit가 2이면 앞에서 두 개만 가져오는지 확인`() = runBlocking {
        // when
        val result = repository.getAlbums(limit = 2)

        // then
        assertEquals(2, result.size)
    }
}