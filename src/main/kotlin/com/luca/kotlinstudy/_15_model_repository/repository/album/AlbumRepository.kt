package com.luca.kotlinstudy._15_model_repository.repository.album

import com.luca.kotlinstudy._15_model_repository.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}