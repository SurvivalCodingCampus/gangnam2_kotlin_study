package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Album

interface AlbumDataSource {
    suspend fun getAllAlbums(): List<Album>

    suspend fun getAlbums(limit: Int? = null): List<Album> {
        val albums = getAllAlbums()
        return if (limit == null) {
            albums
        } else {
            albums.take(limit)
        }
    }
}
