package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.repository

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}