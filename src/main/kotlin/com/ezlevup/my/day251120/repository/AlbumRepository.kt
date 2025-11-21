package com.ezlevup.my.day251120.repository

import com.ezlevup.my.day251120.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}
