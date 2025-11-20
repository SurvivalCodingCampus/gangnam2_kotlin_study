package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fifth

import java.io.File

class MockAlbumDataSourceImpl(val file: File) : AlbumDataSource {
    override suspend fun getAlbum() = listOf(
        Album(1L, 1L, "title1"),
        Album(2L, 1L, "title2"),
        Album(3L, 2L, "title3"),
        Album(4L, 3L, "title4"),
        Album(5L, 2L, "title5")
    )
}