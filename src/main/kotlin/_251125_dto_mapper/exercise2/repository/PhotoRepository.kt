package _251125_dto_mapper.exercise2.repository

import _251125_dto_mapper.exercise2.model.Photo

interface PhotoRepository {
    suspend fun getAllPhotos(): List<Photo>
}