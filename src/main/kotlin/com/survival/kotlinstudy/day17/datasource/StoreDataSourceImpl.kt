package com.survival.kotlinstudy.day17.datasource

import com.survival.kotlinstudy.day17.dto.StoreListDto
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : StoreDataSource {

    override suspend fun getStores(): StoreListDto {
        val response =
            client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
        return Json.decodeFromString<StoreListDto>(response.bodyAsText())
    }

}