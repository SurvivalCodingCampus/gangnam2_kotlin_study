package com.luca.kotlinstudy._15_model_repository.repository.album

import com.luca.kotlinstudy._15_model_repository.dataSource.album.AlbumDatasource
import com.luca.kotlinstudy._15_model_repository.model.Album

class AlbumRepositoryImpl(
    private val dataSource: AlbumDatasource
) : AlbumRepository {

    override suspend fun getAlbums(limit: Int?): List<Album>
    {
        val all = dataSource.getAlbums()
        return when {
            limit == null -> all              // limit 아니면 전체
            limit <= 0 -> emptyList()
            else -> all.take(limit)
        }
    }
}