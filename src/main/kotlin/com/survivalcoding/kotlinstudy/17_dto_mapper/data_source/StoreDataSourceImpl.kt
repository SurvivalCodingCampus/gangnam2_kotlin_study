package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.core.HttpClientFactory
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.StoresDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : StoreDataSource {
    override suspend fun getStores(): List<StoreDto> {
        val response = client.get(
            "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
        )

        // StoresDto로 응답 본문을 역직렬화
        val storesDto: StoresDto = response.body()

        // stores 필드가 null일 경우 빈 리스트 반환
        return storesDto.stores ?: emptyList()
    }
}
