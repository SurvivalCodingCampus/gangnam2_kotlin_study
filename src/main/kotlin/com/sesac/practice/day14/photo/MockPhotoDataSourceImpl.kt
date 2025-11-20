package com.sesac.practice.day14.photo

import com.sesac.practice.day14.decodeFromFile
import java.io.File

class MockPhotoDataSourceImpl(
    private val pathname: String,
) : PhotoDataSource {

    override suspend fun getPhotos(): List<Photo> {
        val file = File(pathname)

        return file.decodeFromFile()
    }
}
