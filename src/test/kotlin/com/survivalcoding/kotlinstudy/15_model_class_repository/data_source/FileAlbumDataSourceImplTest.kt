package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Album
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class FileAlbumDataSourceImplTest {
    companion object {
        private const val AlBUMS_SIZE = 100
    }

    private val dataSource = FileAlbumDataSourceImpl()

    @Test
    fun `Album 리스트 확인 - 리스트 모두 불러보기`(): Unit = runBlocking {
        // when
        val albums = dataSource.getAlbums()

        // then
        assertTrue(albums.isNotEmpty())
        assertEquals(AlBUMS_SIZE, albums.size)
        assertIs<List<Album>>(albums)
    }

    @Test
    fun `Album 역직렬화 - 타입 체크`() = runBlocking {
        // when
        val albums = dataSource.getAlbums()

        // then
        albums.forEach {
            assertTrue { it is Album }
            assertTrue { it.id is Int }
            assertTrue { it.userId is Int }
            assertTrue { it.title is String }
        }

    }

}