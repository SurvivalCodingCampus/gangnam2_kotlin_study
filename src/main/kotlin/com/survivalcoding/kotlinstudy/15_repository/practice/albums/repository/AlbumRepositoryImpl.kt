package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.data_source.AlbumDataSource
import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model.Album

class AlbumRepositoryImpl(
    private val dataSource: AlbumDataSource
) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albumSource = dataSource.getAlbumFileData()
        return albumSource.filterIndexed { index, _ ->
            if (limit != null) index < limit
            else true
        }
    }
}