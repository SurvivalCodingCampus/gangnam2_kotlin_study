package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.AlbumDataSource
import com.survival.kotlinstudy.day15.model.Album

class AlbumRepositoryImpl(
    private val dataSource: AlbumDataSource
) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return if (limit == null) {
            dataSource.getAlbums()
        } else {
            dataSource.getAlbums().take(limit)
        }
    }
}