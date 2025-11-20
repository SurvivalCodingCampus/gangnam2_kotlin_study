package com.luca.kotlinstudy._15_model_repository.dataSource.album

import com.luca.kotlinstudy._15_model_repository.model.Album

// 테스트에서 사용할 Mock Album 데이터소스
class MockAlbumDatasourceImpl : AlbumDatasource {

    override suspend fun getAlbums(): List<Album> {
        return listOf(
            Album(1, 1, "Mock Album 1"),
            Album(1, 2, "Mock Album 2"),
            Album(2, 3, "Mock Album 3"),
            Album(2, 4, "Mock Album 4"),
        )
    }
}
