package com.luca.kotlinstudy._17_dto.datasource

import com.luca.kotlinstudy._17_dto.dto.StoreDTO
import com.luca.kotlinstudy._17_dto.dto.StoreList
import com.luca.kotlinstudy.core.HttpClientFactory
import com.luca.kotlinstudy.core.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.util.toMap

class StoreDataSourceImpl(
    private val httpClient: HttpClient = HttpClientFactory.create(),
    private val url: String =
        "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
) : StoreDataSource {

    override suspend fun getStores(): Response<List<StoreDTO>> {
        val httpResponse = httpClient.get(url)

        if (!httpResponse.status.isSuccess()) {
            return Response(
                statusCode = httpResponse.status.value,
                headers = httpResponse.headers.toMap(),
                body = null
            )
        }

        val storeList: StoreList = httpResponse.body()

        return Response(
            statusCode = httpResponse.status.value,
            headers = httpResponse.headers.toMap(),
            body = storeList.stores
        )
    }
}
