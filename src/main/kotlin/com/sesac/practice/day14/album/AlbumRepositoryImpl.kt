package com.sesac.practice.day14.album

class AlbumRepositoryImpl(
    private val albumDataSource: AlbumDataSource,
) : AlbumRepository {

    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = albumDataSource.getAlbums()

        if (limit == null) {
            return albums
        }

        return albums.take(limit)
    }
}
