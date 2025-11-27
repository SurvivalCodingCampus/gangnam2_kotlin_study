package com.ezlevup.my.day251126.exercise.data_source

import com.ezlevup.my.core.HttpClientProvider
import com.ezlevup.my.core.Response
import com.ezlevup.my.core.toResponse
import com.ezlevup.my.day251126.exercise.dto.UserDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class UserDataSourceImpl(
    private val client: HttpClient = HttpClientProvider.client,
) : UserDataSource {
    val baseUrl = "https://jsonplaceholder.typicode.com"

    override suspend fun getUsers(): Response<List<UserDto>> = withContext(Dispatchers.IO) {
        val httpResponse = client.get("$baseUrl/users")
        httpResponse.toResponse<List<UserDto>>()
    }

    override suspend fun getUser(id: Int): Response<UserDto> = withContext(Dispatchers.IO) {
        val httpResponse = client.get("$baseUrl/users/${id}")
        httpResponse.toResponse<UserDto>()
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> = withContext(Dispatchers.IO) {
        val httpResponse = client.post("$baseUrl/users") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(user))  // 수동 직렬화
        }

        return@withContext httpResponse.toResponse<UserDto>()
    }
}
