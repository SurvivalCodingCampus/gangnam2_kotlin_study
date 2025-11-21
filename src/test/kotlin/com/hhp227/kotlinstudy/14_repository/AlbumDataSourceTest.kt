package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull

class AlbumDataSourceTest {
    val mockAlbumDataSource = MockAlbumDataSourceImpl(filename = "albums.json")

    @Test
    fun `파일이 존재하는지 확인`() {
        val albumsJson = this::class.java.classLoader.getResource("albums.json")

        assertNotNull(albumsJson, "albums.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `Album리스트를 모두 불러오는지 테스트`() = runTest {
        val albumList = mockAlbumDataSource.getAllAlbum()

        assertIs<List<Album>>(albumList)
    }

    @Test
    fun `Album리스트 크기가 일치한지 테스트`() = runTest {
        val albumList = mockAlbumDataSource.getAllAlbum()
        val expected = 100

        assertEquals(expected, albumList.size)
    }

    @Test
    fun `Album리스트 첫번째 아이템이 일치한지 테스트`() = runTest {
        val expected = Album(
            userId = 1,
            id = 1,
            title = "quidem molestiae enim"
        )
        val albumList = mockAlbumDataSource.getAllAlbum()
        val firstAlbum = albumList.first()

        assertEquals(expected, firstAlbum)
    }

    @Test
    fun `Album리스트 마지막 아이템이 일치한지 테스트`() = runTest {
        val expected = Album(
            userId = 10,
            id = 100,
            title = "enim repellat iste"
        )
        val albumList = mockAlbumDataSource.getAllAlbum()
        val lastAlbum = albumList.last()

        assertEquals(expected, lastAlbum)
    }
}