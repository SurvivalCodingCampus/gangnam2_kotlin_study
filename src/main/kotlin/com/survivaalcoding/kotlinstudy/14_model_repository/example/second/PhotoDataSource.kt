package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

interface PhotoDataSource {
    suspend fun getPhoto(): List<Photo>
}
