package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Album

class MockAlbumDataSourceImpl : AlbumDataSource {
    val album1 = Album(userId = 1, id = 1, title = "song1")
    val album2 = Album(userId = 2, id = 2, title = "song2")
    val album3 = Album(userId = 3, id = 3, title = "song3")
    val album4 = Album(userId = 4, id = 4, title = "song4")
    val album5 = Album(userId = 5, id = 5, title = "song5")
    val album6 = Album(userId = 6, id = 6, title = "song6")
    val list = listOf(album1, album2, album3, album4, album5, album6)

    override suspend fun getAlbums(): List<Album> {
        return list
    }

}