package _251120_test_double_model_class_repository.exercise2

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return photoDataSource.getAllPhotos().filter { it.albumId == albumId }
    }
}