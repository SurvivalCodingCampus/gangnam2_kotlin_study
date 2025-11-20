package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.day15.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(): List<Album>
}