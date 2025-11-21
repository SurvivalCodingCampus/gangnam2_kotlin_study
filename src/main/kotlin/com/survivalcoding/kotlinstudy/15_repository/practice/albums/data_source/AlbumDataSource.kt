package com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.albums.model.Album

interface AlbumDataSource {
    suspend fun getAlbumFileData(): List<Album>
}