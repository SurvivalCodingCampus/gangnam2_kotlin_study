package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Album
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MockAlbumDataSourceImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 5
    }

    private val dataSource = MockAlbumDataSourceImpl()

    @Test
    fun `Album mock 데이터 - 리스트 검사`(): Unit = runBlocking {
        // when
        val albums = dataSource.getAlbums()

        // then
        assertTrue(albums.isNotEmpty())
        assertEquals(MOCK_DATA_SIZE, albums.size)
        assertIs<List<Album>>(albums)
    }

    @Test
    fun `Album mock 데이터 - 필드 타입 검사`() = runBlocking {
        // when
        val albums = dataSource.getAlbums()

        // then
        albums.forEach { album ->
            assertTrue(album.userId is Int)
            assertTrue(album.id is Int)
            assertTrue(album.title is String)
        }
    }
}
