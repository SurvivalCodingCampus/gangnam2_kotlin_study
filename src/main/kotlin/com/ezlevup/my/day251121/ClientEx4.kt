package com.ezlevup.my.day251121

import com.ezlevup.my.day251121.exercise.core.FileUtils
import com.ezlevup.my.day251121.exercise.data_source.ImageDataSourceImpl
import com.ezlevup.my.day251121.exercise.repository.ImageRepositoryImpl
import kotlinx.coroutines.runBlocking
import java.io.File


fun main(): Unit = runBlocking {
    val directory: String = "images"
    val dir = File(directory)
    if (!dir.exists()) {
        dir.mkdirs()
    }

    val url = "https://shopping-phinf.pstatic.net/main_5621418/56214188047.20250812122730.jpg?type=w300"
    val fileName = FileUtils.extractFileName(url)
    println(fileName)

    val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())

    val savePath = "$directory/$fileName"
    imageRepository.saveImage(url, savePath)


}