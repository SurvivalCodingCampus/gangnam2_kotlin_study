package com.sesac.practice.day14.album

interface AlbumDataSource {
    suspend fun getAlbums(): List<Album>
}
