package _251120_test_double_model_class_repository.exercise5

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}