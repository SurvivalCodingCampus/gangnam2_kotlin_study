package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.data_source

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.dto.PhotoDto
import com.survivalcoding.kotlinstudy.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
): PhotoDataSource {

    private val json = Json{
        ignoreUnknownKeys = true
    }

    override suspend fun getPhotos(): List<PhotoDto> {
        val response: HttpResponse = client.get("url")
        val body: String = response.bodyAsText()
        val dto: List<PhotoDto> = json.decodeFromString(body)

        return dto
    }

    override suspend fun getPhoto(id: Int): PhotoDto {
        val response = client.get("url")
        val body: String = response.bodyAsText()
        val dto: List<PhotoDto> = json.decodeFromString(body)

        return dto.first { it.id == id }
    }
}