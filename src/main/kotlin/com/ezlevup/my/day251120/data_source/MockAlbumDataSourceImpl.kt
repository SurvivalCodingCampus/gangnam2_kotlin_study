package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Album

class MockAlbumDataSourceImpl(
    private val albums: List<Album> = emptyList()
) : AlbumDataSource {
    override suspend fun getAllAlbums(): List<Album> {
        return albums
    }
}
