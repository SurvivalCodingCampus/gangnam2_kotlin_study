package _251120_test_double_model_class_repository.exercise5

class MockAlbumDataSourceImpl : AlbumDataSource {
    val mockAlbumList = listOf(
        Album(userId = 1, id = 1, title = "title1"),
        Album(userId = 2, id = 2, title = "title2"),
        Album(userId = 3, id = 3, title = "title3"),
        Album(userId = 4, id = 4, title = "title4"),
        Album(userId = 5, id = 5, title = "title5"),
        Album(userId = 6, id = 6, title = "title6"),
    )

    override suspend fun getAllAlbum(): List<Album> {
        return mockAlbumList
    }
}
