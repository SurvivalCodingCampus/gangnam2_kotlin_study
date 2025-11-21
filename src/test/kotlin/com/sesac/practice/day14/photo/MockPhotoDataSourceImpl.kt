package com.sesac.practice.day14.photo

class MockPhotoDataSourceImpl() : PhotoDataSource {

    override suspend fun getPhotos(): List<Photo> {
        return listOf(
            Photo(1, 1, "title1", "url1", "thumbnailUrl1"),
            Photo(1, 2, "title2", "url2", "thumbnailUrl2"),
            Photo(2, 1, "title3", "url3", "thumbnailUrl3"),
            Photo(2, 2, "title4", "url4", "thumbnailUrl4"),
        )
    }
}
