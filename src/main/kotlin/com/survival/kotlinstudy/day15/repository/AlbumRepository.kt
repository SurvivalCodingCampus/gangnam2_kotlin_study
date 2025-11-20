package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}