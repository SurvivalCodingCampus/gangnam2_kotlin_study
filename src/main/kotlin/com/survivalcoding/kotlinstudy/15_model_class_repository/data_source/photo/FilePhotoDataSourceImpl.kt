package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.photo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Photo
import com.survivalcoding.kotlinstudy.common.readJsonFile

class FilePhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotos(): List<Photo> {
        return readJsonFile("src/main/resources/15_model_class_repository/photos.json")
    }
}