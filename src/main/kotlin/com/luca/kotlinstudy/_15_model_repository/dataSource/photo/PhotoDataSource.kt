package com.luca.kotlinstudy._15_model_repository.dataSource.photo

import com.luca.kotlinstudy._15_model_repository.model.Photo


interface PhotoDataSource {
    suspend fun getComments(albumId: Int): List<Photo>
}