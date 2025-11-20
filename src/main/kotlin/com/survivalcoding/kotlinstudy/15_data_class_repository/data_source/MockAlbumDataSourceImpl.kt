package com.survivalcoding.kotlinstudy.`15_data_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_data_class_repository`.model.Album

class MockAlbumDataSourceImpl : AlbumDataSource {

    private val mockAlbums = listOf(
        Album(1, 1, "quidem molestiae enim"),
        Album(1, 2, "sunt qui excepturi placeat culpa"),
        Album(2, 3, "omnis laborum odio"),
        Album(2, 4, "non esse culpa molestiae omnis sed optio"),
        Album(3, 5, "eaque aut omnis a")
    )

    override suspend fun getAlbums(): List<Album> {
        return mockAlbums
    }
}