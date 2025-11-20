package com.luca.kotlinstudy._15_model_repository.dataSource.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo

// 테스트에서 사용할 Mock Photo DataSource
class MockPhotoDatasourceImpl : PhotoDatasource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val all = listOf(
            Photo(1, 1, "Mock Photo 1", "", ""),
            Photo(1, 2, "Mock Photo 2", "", ""),
            Photo(2, 3, "Mock Photo 3", "", ""),
        )
        val photos = all.filter { it.albumId == albumId }
        return photos
    }
}
