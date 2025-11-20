package com.hhp227.kotlinstudy.`14_repository`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class AlbumRepositoryTest {
    private val albumRepository = AlbumRepositoryImpl(MockAlbumDataSourceImpl(filename = "albums.json"))

    @Test
    fun `AlbumRepository에서 모든 아이템을 가져와서 크기가 맞는지 테스트`() = runTest {
        val albumList = albumRepository.getAlbums()
        val expected = 100

        assertEquals(expected, albumList.size)
    }

    @Test
    fun `AlbumRepository에서 AlbumList 10개 가져와서 일치하는지 테스트`() = runTest {
        val expected = 10
        val albumList = albumRepository.getAlbums(10)

        assertEquals(expected, albumList.size)
    }

    @Test
    fun `AlbumRepository에서 limit을 3개 걸고 가져와서 일치하는지 테스트`() = runTest {
        val albumList = albumRepository.getAlbums(3)
        val expected = listOf(
            Album(
                userId = 1,
                id = 1,
                title = "quidem molestiae enim"
            ),
            Album(
                userId = 1,
                id = 2,
                title = "sunt qui excepturi placeat culpa"
            ),
            Album(
                userId = 1,
                id = 3,
                title = "omnis laborum odio"
            )
        )

        assertEquals(expected, albumList)
    }
}