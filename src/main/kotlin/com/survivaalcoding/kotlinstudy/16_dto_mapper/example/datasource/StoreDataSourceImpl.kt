package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.core.HttpClientFactory
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.core.Response
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.StoreResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StoreDataSourceImpl(private val httpClient: HttpClient = HttpClientFactory.create()) : StoreDataSource {
    override suspend fun getStores(): Response<StoreResponse> = withContext(Dispatchers.IO) {
        val response = httpClient.get(BASE_URL)

        if (!response.status.isSuccess()) {
            throw RuntimeException("데이터 요청에 실패했습니다.")
        }

        Response(
            statusCode = response.status.value,
            headers = response.headers.toMap(),
            body = response.body()
        )
    }

    companion object {
        private const val BASE_URL =
            "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
    }
}