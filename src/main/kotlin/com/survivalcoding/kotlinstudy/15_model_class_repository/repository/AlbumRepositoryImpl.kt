package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.AlbumDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Album

class AlbumRepositoryImpl(
    private val dataSource: AlbumDataSource
) : AlbumRepository {

    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.getAlbums()

        return if (limit == null) {
            albums
        } else {
            albums.take(limit)
        }
    }
}