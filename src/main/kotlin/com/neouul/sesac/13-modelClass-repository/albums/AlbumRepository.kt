package com.neouul.sesac.`13-modelClass-repository`.albums

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}

class AlbumRepositoryImpl(
    private val dataSource: AlbumDataSource,
) : AlbumRepository {
    // limit 을 지정하지 않으면 모든 데이터를 반환
    // limit 을 지정하면 limit 갯수만큼 반환
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.loadAlbums()
        return albums.take(limit ?: albums.size)
    }
}