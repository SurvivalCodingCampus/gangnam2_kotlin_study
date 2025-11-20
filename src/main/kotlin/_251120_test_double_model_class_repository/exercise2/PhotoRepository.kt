package _251120_test_double_model_class_repository.exercise2

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}