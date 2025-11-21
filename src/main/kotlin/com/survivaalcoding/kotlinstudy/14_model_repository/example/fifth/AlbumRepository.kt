package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}