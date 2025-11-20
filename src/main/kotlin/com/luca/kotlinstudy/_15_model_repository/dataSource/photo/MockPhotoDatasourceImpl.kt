package com.luca.kotlinstudy._15_model_repository.dataSource.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo

// 테스트에서 사용할 Mock Photo DataSource
class MockPhotoDatasourceImpl : PhotoDatasource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val all = listOf(
            Photo(albumId = 1, id = 1, title = "Mock Photo 1", url = "", thumbnailUrl = ""),
            Photo(albumId = 1, id = 2, title = "Mock Photo 2", url = "", thumbnailUrl = ""),
            Photo(albumId = 2, id = 3, title = "Mock Photo 3", url = "", thumbnailUrl = ""),
        )
        val photos = all.filter { it.albumId == albumId }
        return photos
    }
}
