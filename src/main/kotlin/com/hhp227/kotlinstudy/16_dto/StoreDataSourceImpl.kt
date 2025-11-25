package com.hhp227.kotlinstudy.`16_dto`

import com.hhp227.kotlinstudy.`13_datasource`.FileLoadUtil
import kotlinx.serialization.json.Json

class StoreDataSourceImpl(
    private val filename: String
) : StoreDataSource {
    override suspend fun fetchMaskStore(): MaskStore {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}