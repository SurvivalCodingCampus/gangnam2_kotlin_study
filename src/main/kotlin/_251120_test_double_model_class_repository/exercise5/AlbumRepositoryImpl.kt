package _251120_test_double_model_class_repository.exercise5

class AlbumRepositoryImpl(val albumDataSource: AlbumDataSource) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        if (limit == null) {
            return albumDataSource.getAllAlbum()
        } else {
            return albumDataSource.getAllAlbum().take(limit)
        }
    }
}