package com.sesac.practice.day16.datasource

import com.sesac.practice.day16.core.Response
import com.sesac.practice.day16.dto.StoresDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

class FileStoreDataSourceImpl(
    private val pathname: String,
) : StoreDataSource {

    override suspend fun getStores(): Response<StoresDto> = withContext(Dispatchers.IO) {
        val file = File(pathname)

        Response(
            200,
            mapOf(),
            Json.decodeFromString(file.readText()),
        )
    }
}
