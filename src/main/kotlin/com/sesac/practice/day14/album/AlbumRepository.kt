package com.sesac.practice.day14.album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}
