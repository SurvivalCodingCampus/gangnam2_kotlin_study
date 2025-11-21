package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

class AlbumRepositoryImpl(val dataSource: AlbumDataSource) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.getAlbum()

        return if (limit != null) albums.take(limit) else albums
    }
}