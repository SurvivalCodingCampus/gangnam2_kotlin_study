package _251125_dto_mapper.exercise2.data_source

import _251125_dto_mapper.exercise2.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(
    private val httpClient: HttpClient
) : PhotoDataSource {
    override suspend fun getAllPhoto(): List<PhotoDto> {
        val result = httpClient.get("test")
        return Json.decodeFromString<List<PhotoDto>>(result.body())
    }
}