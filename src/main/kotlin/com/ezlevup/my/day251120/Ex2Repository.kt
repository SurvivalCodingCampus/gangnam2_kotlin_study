package com.ezlevup.my.day251120


import com.ezlevup.my.day251120.data_source.FilePhotoDataSourceImpl
import com.ezlevup.my.day251120.data_source.MockPhotoDataSourceImpl
import com.ezlevup.my.day251120.repository.PhotoRepositoryImpl
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val photo = PhotoRepositoryImpl(FilePhotoDataSourceImpl())
    println(photo.getPhotos(1).count())

    PhotoRepositoryImpl(MockPhotoDataSourceImpl())
        .getPhotos(1)
        .forEach(::println)
}
