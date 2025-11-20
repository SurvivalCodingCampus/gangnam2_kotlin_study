package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import java.io.File

class MockPhotoDataSourceImpl(val file: File) : PhotoDataSource {
    override suspend fun getPhoto() = listOf(
        Photo(1L, 1L, "title1", "https://url1.com", "https://thubmail1.com"),
        Photo(2L, 2L, "title2", "https://url2.com", "https://thubmail2.com")
    )
}