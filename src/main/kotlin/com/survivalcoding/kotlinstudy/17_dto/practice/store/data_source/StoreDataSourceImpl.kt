package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.data_source

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.dto.StoreListResponseDto
import com.survivalcoding.kotlinstudy.HttpClientFactory
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
): StoreDataSource {
    override suspend fun getStores(): List<StoreDto> {
        val response = client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
        val body: String = response.bodyAsText()
        val dto: StoreListResponseDto = Json.decodeFromString(body)
        return dto.stores
    }

    override suspend fun getStore(code: Int): StoreDto {
        val response = client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
        val body: String = response.bodyAsText()
        val dto: StoreListResponseDto = Json.decodeFromString(body)
        return dto.stores.first { it.code == code.toString() }
    }
}