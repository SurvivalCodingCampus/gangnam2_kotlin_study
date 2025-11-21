package com.sesac.practice.day14.album

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {

    private val dataSource = MockAlbumDataSourceImpl()

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
