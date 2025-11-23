package com.neouul.sesac.`14-network`.Exercise.data_source

import com.neouul.sesac.`14-network`.Exercise.core.Response
import com.neouul.sesac.`14-network`.Exercise.core.ResponseFactory
import com.neouul.sesac.`14-network`.Exercise.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : RemoteDataSource {

    // post 조회
    override suspend fun getPosts(): Response<String> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts")

        return ResponseFactory.create(response)
    }

    override suspend fun getPost(id: Int): Response<String> {
        val response = client.get("https://jsonplaceholder.typicode.com/posts/$id")

        return ResponseFactory.create(response)
    }

    // post 생성
    override suspend fun createPost(post: Post): Response<String> {
        val response = client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)   // 서버에 전송할 컨텐츠 설정
            setBody(post)   // post 객체를 JSON으로 직렬화하여 본문에 포함
        }

        return ResponseFactory.create(response)
    }

    // post 속성 전부 업데이트
    override suspend fun updatePost(
        id: Int,
        post: Post
    ): Response<String> {
        val response = client.put("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return ResponseFactory.create(response)
    }

    // post의 일부 속성 업데이트
    override suspend fun patchPost(
        id: Int,
        post: Post
    ): Response<String> {
        val response = client.patch("https://jsonplaceholder.typicode.com/posts/$id") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }

        return ResponseFactory.create(response)
    }

    // post 삭제
    override suspend fun deletePost(id: Int): Response<String> {
        // 삭제 요청은 본문 없이 URL 경로를 통해 ID를 전달
        val response = client.delete("https://jsonplaceholder.typicode.com/posts/$id")

        return ResponseFactory.create(response)
    }
}