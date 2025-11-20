package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockPhotoDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    @Test
    fun `PhotoRepositoryImpl getPhotos() 테스트`(): Unit = runBlocking {
        val filePath = "data/photos.json"
        val repository = PhotoRepositoryImpl(MockPhotoDataSourceImpl(filePath))

        val list = repository.getPhotos(1)

        assertEquals(50,list.size)


    }
}