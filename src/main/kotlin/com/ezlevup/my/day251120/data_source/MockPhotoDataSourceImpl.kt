package com.ezlevup.my.day251120.data_source

import com.ezlevup.my.day251120.model.Photo


class MockPhotoDataSourceImpl(
    val fileName: String = "no-file.json",
) : PhotoDataSource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return listOf(
            Photo(albumId = 1, id = 1, title = "lee1", url = "lee1.naver.com", thumbnailUrl = "f1.com"),
            Photo(albumId = 1, id = 2, title = "lee2", url = "lee2.naver.com", thumbnailUrl = "f2.com"),
        )
    }
}