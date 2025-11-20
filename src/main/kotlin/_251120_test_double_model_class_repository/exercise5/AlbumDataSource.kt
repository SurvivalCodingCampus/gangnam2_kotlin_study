package _251120_test_double_model_class_repository.exercise5

interface AlbumDataSource {
    suspend fun getAllAlbum(): List<Album>
}