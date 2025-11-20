package com.sesac.practice.day14.album

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class FileAlbumDataSourceImplTest {
    @Test
    fun `albums_json 파일을 읽어서 Album 리스트로 반환한다`() = runTest {
        // given
        val pathname = "data/albums.json"
        val dataSource = FileAlbumDataSourceImpl(pathname)

        // when
        val albums = dataSource.getAlbums()

        // then
        assertEquals(100, albums.size)
    }
}
