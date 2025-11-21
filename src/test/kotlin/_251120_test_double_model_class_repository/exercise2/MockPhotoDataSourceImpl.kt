package _251120_test_double_model_class_repository.exercise2

class MockPhotoDataSourceImpl : PhotoDataSource {
    val mockPhotoList = listOf(
        Photo(1, 1, "thumbnailUrl1", "title1", "url1"),
        Photo(2, 2, "thumbnailUrl2", "title2", "url2"),
        Photo(3, 3, "thumbnailUrl3", "title3", "url3"),
        Photo(4, 4, "thumbnailUrl4", "title4", "url4")

    )

    override suspend fun getAllPhotos(): List<Photo> {
        return mockPhotoList
    }
}