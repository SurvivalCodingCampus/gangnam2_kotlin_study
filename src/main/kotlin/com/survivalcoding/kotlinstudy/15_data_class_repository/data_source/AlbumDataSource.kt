package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(): List<Album>
}