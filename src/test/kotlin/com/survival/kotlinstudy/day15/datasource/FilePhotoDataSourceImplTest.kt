package com.survival.kotlinstudy.day15.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test

class FilePhotoDataSourceImplTest {
    @Test
    fun `FilePhotoDataSource - getPhotos 테스트`() = runBlocking {
        val filePath = "data/photos.json"
        val datasource = FilePhotoDataSourceImpl(filePath)
        val list = datasource.getPhotos()

        kotlin.test.assertEquals(5000, list.size)
    }
}