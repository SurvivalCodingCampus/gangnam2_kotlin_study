package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockAlbumDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {
    @Test
    fun `AlbumRepository - getAlbums() 테스트`() = runBlocking {
        val repository = AlbumRepositoryImpl(MockAlbumDataSourceImpl())
        val expected = 3

        val list = repository.getAlbums(expected)

        assertEquals(expected, list.size)

    }

    @Test
    fun `AlbumRepository - getAlbums() limit이 없을 경우 테스트`() = runBlocking {
        val repository = AlbumRepositoryImpl(MockAlbumDataSourceImpl())
        val expected = 6

        val list = repository.getAlbums()

        assertEquals(expected, list.size)

    }
}