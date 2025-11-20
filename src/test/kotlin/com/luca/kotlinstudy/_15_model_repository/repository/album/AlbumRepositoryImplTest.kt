package com.luca.kotlinstudy._15_model_repository.repository.album

import com.luca.kotlinstudy._15_model_repository.dataSource.album.MockAlbumDatasourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class AlbumRepositoryImplTest {

    private val mockDataSource = MockAlbumDatasourceImpl()
    private val repository = AlbumRepositoryImpl(mockDataSource)

    @Test
    fun `limit이 null이면 모든 앨범을 반환한다`() = runBlocking {
        val result = repository.getAlbums()

        assertEquals(4, result.size)
    }

    @Test
    fun `limit을 지정하면 해당 개수만큼 반환한다`() = runBlocking {
        val result = repository.getAlbums(limit = 2)

        assertEquals(2, result.size)
    }

    @Test
    fun `limit이 0이면 빈 리스트 반환`() = runBlocking {
        val result = repository.getAlbums(limit = 0)

        assertEquals(0, result.size)
    }
}
