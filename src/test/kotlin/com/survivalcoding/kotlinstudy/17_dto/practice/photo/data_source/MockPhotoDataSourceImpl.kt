package com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.data_source

import com.survivalcoding.kotlinstudy.`17_dto`.practice.photo.dto.PhotoDto
import com.survivalcoding.kotlinstudy.HttpClientFactory
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : PhotoDataSource {

    private val json: Json = Json {
        ignoreUnknownKeys = true
    }

    override suspend fun getPhotos(): List<PhotoDto> {
        return json.decodeFromString(MOCK_JSON)
    }

    override suspend fun getPhoto(id: Int): PhotoDto {
        val photos: List<PhotoDto> = getPhotos()

        return photos.first { it.id?.toInt() == id }
    }

    private companion object {
        private const val MOCK_JSON: String = """
[
  {
    "id": "1",
    "type": "article",
    "title": "This is an article",
    "content": "This is the content of the article.",
    "created_at": "2020-01-01"
  },
  {
    "id": 2,
    "type": null,
    "url": "https://example.com/image.jpg",
    "caption": "This is an image.",
    "created_at": "2020-02-02"
  },
  {
    "id": 3,
    "url": "https://example.com/video.mp4",
    "caption": "This is a video.",
    "created_at": "2020-03-03"
  }
]
"""
    }
}
