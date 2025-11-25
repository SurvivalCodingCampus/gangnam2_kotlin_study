package com.ezlevup.my.day251125.exercise.data_source

import com.ezlevup.my.core.Response
import com.ezlevup.my.core.toResponse
import com.ezlevup.my.day251125.exercise.dto.PhotoDto
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(
    mockPhotos: List<PhotoDto>
) : PhotoDataSource {

    private val mockEngine = MockEngine.Companion { request ->
        respond(
            content = Json.Default.encodeToString(mockPhotos),
            status = HttpStatusCode.Companion.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private val client: HttpClient = HttpClient(mockEngine)

    override suspend fun getPhotos(): Response<List<PhotoDto>> {
        val httpResponse = client.get("https://")
        return httpResponse.toResponse<List<PhotoDto>>()
    }
}