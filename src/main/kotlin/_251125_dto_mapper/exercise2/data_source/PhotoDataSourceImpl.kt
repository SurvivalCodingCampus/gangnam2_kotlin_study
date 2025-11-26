package _251125_dto_mapper.exercise2.data_source

import _251125_dto_mapper.exercise2.core.Response
import _251125_dto_mapper.exercise2.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(
    private val httpClient: HttpClient
) : PhotoDataSource {
    override suspend fun getAllPhoto(): Response<List<PhotoDto>> {
        val result = httpClient.get("test1")

        return Response(
            body = Json.decodeFromString<List<PhotoDto>>(result.bodyAsText()),
            statusCode = result.status.toString()
        )
    }
}