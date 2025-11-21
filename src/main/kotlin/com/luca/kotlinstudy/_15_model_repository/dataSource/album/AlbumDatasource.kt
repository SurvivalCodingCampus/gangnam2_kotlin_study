package com.luca.kotlinstudy._15_model_repository.dataSource.album

import com.luca.kotlinstudy._15_model_repository.model.Album

interface AlbumDatasource {
    suspend fun getAlbums(): List<Album>
}
