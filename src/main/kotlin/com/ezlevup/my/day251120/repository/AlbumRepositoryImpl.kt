package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.data_source.AlbumDataSource
import com.ezlevup.my.day251120.model.Album

class AlbumRepositoryImpl(
    val albumDataSource: AlbumDataSource
) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return albumDataSource.getAlbums(limit)
    }
}
