package _251125_dto_mapper.exercise1.data_source

import _251125_dto_mapper.exercise1.core.HttpClientFactory
import _251125_dto_mapper.exercise1.core.Response
import _251125_dto_mapper.exercise1.dto.Stores
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class StoreDataSourceImpl(
    private val httpClient: HttpClient = HttpClientFactory.create()
) : StoreDataSource {
    override suspend fun getAllStore(): Response<Stores> {
        val result =
            httpClient.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
        return Response(
            body = Json.decodeFromString<Stores>(result.bodyAsText()),
            statusCode = result.status
        )
    }
}