package com.survival.kotlinstudy.day15.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals


class FileAlbumDataSourceImplTest {
    @Test
    fun `FileAlbumDataSource- getAlbums() 테스트`() = runBlocking {
        val filePath = "data/albums.json"
        val dataSource = FileAlbumDataSourceImpl(filePath)
        val expected = 100

        val list = dataSource.getAlbums()

        assertEquals(expected, list.size)

    }

}