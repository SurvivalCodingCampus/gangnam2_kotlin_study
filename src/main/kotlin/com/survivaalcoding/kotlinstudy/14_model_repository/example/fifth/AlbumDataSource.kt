package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

interface AlbumDataSource {
    suspend fun getAlbum(): List<Album>
}
