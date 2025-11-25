package com.hhp227.kotlinstudy.`16_dto`

import com.hhp227.kotlinstudy.`13_datasource`.FileLoadUtil
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(
    private val filename: String
) : PhotoDataSource {
    override suspend fun fetchPhotos(): List<PhotoDto> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}