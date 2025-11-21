package com.sesac.practice.day14.album

import com.sesac.practice.day14.decodeFromFile
import java.io.File

class FileAlbumDataSourceImpl(
    private val pathname: String,
) : AlbumDataSource {

    override suspend fun getAlbums(): List<Album> {
        val file = File(pathname)

        return file.decodeFromFile()
    }
}
