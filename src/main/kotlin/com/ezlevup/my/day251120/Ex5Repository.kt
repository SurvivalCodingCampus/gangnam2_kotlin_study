package com.ezlevup.my.day251120

import com.ezlevup.my.day251120.data_source.FileAlbumDataSourceImpl
import com.ezlevup.my.day251120.data_source.MockAlbumDataSourceImpl
import com.ezlevup.my.day251120.model.Album
import com.ezlevup.my.day251120.repository.AlbumRepositoryImpl
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val albumRepository = AlbumRepositoryImpl(FileAlbumDataSourceImpl())
    albumRepository.getAlbums(1).forEach(::println)

    val albums = listOf(
        Album(userId = 1, id = 1, title = "lee1"),
        Album(userId = 1, id = 2, title = "lee2"),
    )
    AlbumRepositoryImpl(MockAlbumDataSourceImpl(albums)).getAlbums().forEach(::println)
    AlbumRepositoryImpl(MockAlbumDataSourceImpl(albums)).getAlbums(1).forEach(::println)
}


