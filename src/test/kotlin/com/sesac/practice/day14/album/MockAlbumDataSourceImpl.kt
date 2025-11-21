package com.sesac.practice.day14.album

class MockAlbumDataSourceImpl() : AlbumDataSource {

    override suspend fun getAlbums(): List<Album> {
        return listOf(
            Album(1, 1, "title1"),
            Album(1, 2, "title2"),
            Album(2, 3, "title3"),
            Album(2, 4, "title4"),
        )
    }
}
