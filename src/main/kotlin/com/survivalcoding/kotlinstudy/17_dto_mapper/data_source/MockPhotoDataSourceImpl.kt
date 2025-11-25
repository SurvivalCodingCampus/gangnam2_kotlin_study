package com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.PhotoDto
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray

class MockPhotoDataSourceImpl : PhotoDataSource {
    private val data = """
    [
      {
        "id": 1,
        "type": "article",
        "title": "This is an article",
        "content": "This is the content of the article.",
        "created_at": "2020-01-01"
      },
      {
        "id": 2,
        "type": "image",
        "url": "https://example.com/image.jpg",
        "caption": "This is an image.",
        "created_at": "2020-02-02"
      },
      {
        "id": 3,
        "type": "video",
        "url": "https://example.com/video.mp4",
        "caption": "This is a video.",
        "created_at": "2020-03-03"
      },
      {
          "id": "4",
          "type": "article",
          "title": "This is an article",
          "content": "This is the content of the article.",
          "created_at": "2020-01-01"
        },
        {
          "id": 5,
          "type": null,
          "url": "https://example.com/image.jpg",
          "caption": "This is an image.",
          "created_at": "2020-02-02"
        },
        {
          "id": 6,
          "url": "https://example.com/video.mp4",
          "caption": "This is a video.",
          "created_at": "2020-03-03"
        }
    ]
""".trimIndent()


    override suspend fun getPhotos(): List<PhotoDto> {
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true  // 문자열 -> 숫자 허용
        }
        
        // 요소 단위로 안전한 파싱
        val jsonArray = json.parseToJsonElement(data).jsonArray

        return jsonArray.mapNotNull { element ->
            try {
                json.decodeFromJsonElement<PhotoDto>(element)
            } catch (e: Exception) {
                // 하나의 항목이 문제여도 전체는 유지
                null
            }
        }
    }
}