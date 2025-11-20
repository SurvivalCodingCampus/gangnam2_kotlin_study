package com.sesac.practice.day14.album

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {

    private val dataSource = object : AlbumDataSource {
        override suspend fun getAlbums(): List<Album> {
            return listOf(
                Album(1, 1, "title1"),
                Album(1, 2, "title2"),
                Album(2, 3, "title3"),
                Album(2, 4, "title4"),
            )
        }
    }

    @Test
    fun `limit가 null일 경우 모든 데이터를 가져온다`() = runTest {
        // given
        val repository = AlbumRepositoryImpl(dataSource)

        // when
        val albums = repository.getAlbums()

        // then
        assertEquals(4, albums.size)
    }

    @Test
    fun `limit를 지정하면 limit 개수만큼 가져온다`() = runTest {
        // given
        val repository = AlbumRepositoryImpl(dataSource)

        // when
        val limit = 1
        val albums = repository.getAlbums(limit)

        // then
        assertEquals(limit, albums.size)
    }
}
