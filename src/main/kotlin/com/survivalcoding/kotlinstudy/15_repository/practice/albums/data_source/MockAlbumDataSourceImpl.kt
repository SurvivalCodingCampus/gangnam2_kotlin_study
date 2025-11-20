package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model.Album

class MockAlbumDataSourceImpl: AlbumDataSource {
    override suspend fun getAlbumFileData(): List<Album> {
        return listOf(
            Album(1, 2, "A"),
            Album(2, 3, "B"),
            Album(3, 4, "C")
        )
    }
}