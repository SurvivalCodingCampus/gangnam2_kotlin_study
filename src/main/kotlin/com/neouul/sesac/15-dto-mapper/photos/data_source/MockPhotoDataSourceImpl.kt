package com.neouul.sesac.`15-dto-mapper`.photos.data_source

import com.neouul.sesac.`15-dto-mapper`.photos.dto.PhotoDTO
import com.neouul.sesac.core.Response
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl : PhotoDataSource {
    private val jsonString = """[
{"id":1, 
"type": "article", 
"title": "This is an article",
"content": "This isthe content ofthe article.",
"created_at": "2020-01-01"
},
{
"id":2,
"type": "image",
"url": "https://example.com//image.jpg", 
"caption": "This isan image.",
"created_at": "2020-02-02"
},
{
"id":3,
"type": "video", 
"url": "https:// example.com/video.mp4",
"caption": "This isa video.",
"created_at": "2020-03-03"
},
{
"id": "1", 
"type": "article", 
"title": "This is an article", 
"content": "This isthe content ofthe article.",
"created_at": "2020-01-01"
},
{
"id":2, 
"type": null, 
"url": "https:// examplecom/ /image.jpg",
"caption": "This isan image.",
"created_at": "2020-02-02"
},
{
"id":3, 
"url": "https://example.com/video.mp4",
"caption": "This is a video.",
"created_at": "2020-03-03"
}
]"""

    private val statusOkInt = HttpStatusCode.OK.value
    private val headers = mapOf("Content-Type" to listOf("application/json"))

    override suspend fun loadPhotos(): Response<List<PhotoDTO?>?> {
        val json = Json {
            isLenient = true               // 조금 더 유연한 파싱 허용
        }

        return Response<List<PhotoDTO?>?>(
            statusCode = statusOkInt,
            header = headers,
            body = json.decodeFromString<List<PhotoDTO?>>(jsonString)
        )
    }
}

fun main (): Unit = runBlocking {
    val dataSource = MockPhotoDataSourceImpl()
    println(dataSource.loadPhotos().body)
}