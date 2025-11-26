package com.survivalcoding.kotlinstudy.`18_result`.practice.data_source

import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import com.survivalcoding.kotlinstudy.HttpClientFactory
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.json.Json

class UserDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : UserDataSource {
    override suspend fun getUser(id: Int): Response<UserDto> {
        val response = client.get("https://jsonplaceholder.typicode.com/users/$id")

        val text: String = response.bodyAsText()

        if (!response.status.isSuccess()) {
            throw IllegalStateException("HTTP ${response.status.value}: $text")
        }

        return Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(text)
        )
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        val response = client.get("https://jsonplaceholder.typicode.com/users")

        val text: String = response.bodyAsText()

        if (!response.status.isSuccess()) {
            throw IllegalStateException("HTTP ${response.status.value}: $text")
        }

        return Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(text)
        )
    }

    override suspend fun createUser(user: User): Response<UserDto> {
        val response = client.post("https://jsonplaceholder.typicode.com/users") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(user))
        }

        val text: String = response.bodyAsText()

        if (!response.status.isSuccess()) {
            throw IllegalStateException("HTTP ${response.status.value}: $text")
        }

        return Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(text)
        )
    }
}