package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.MockAlbumDataSourceImpl
import com.ezlevup.my.day251120.model.Album
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AlbumRepositoryImplTest {
    @Test
    fun `AlbumRepositoryImpl 생성자`() {
        // given
        val albumRepository = AlbumRepositoryImpl(MockAlbumDataSourceImpl())

        // when & then
        assertNotNull(albumRepository)
    }

    @Test
    fun `AlbumRepositoryImpl getAlbums() 확인`(): Unit = runBlocking {
        // given
        val albums = listOf(
            Album(userId = 1, id = 1, title = "lee1"),
            Album(userId = 1, id = 2, title = "lee2"),
        )
        val albumRepository = AlbumRepositoryImpl(MockAlbumDataSourceImpl(albums))

        // when
        val result = albumRepository.getAlbums()

        // then
        assertEquals(albums.count(), result.count())
    }

    @Test
    fun `AlbumRepositoryImpl getAlbums(int) 확인`(): Unit = runBlocking {
        // given
        val albums = listOf(
            Album(userId = 1, id = 1, title = "lee1"),
            Album(userId = 1, id = 2, title = "lee2"),
        )
        val albumRepository = AlbumRepositoryImpl(MockAlbumDataSourceImpl(albums))

        // when
        val limit = 1
        val result = albumRepository.getAlbums(limit)

        // then
        assertEquals(albums.take(limit).count(), result.count())
    }
}