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
    override suspend fun getUsers(): Response<List<UserDto>> = withContext(Dispatchers.IO) {
        val httpResponse = client.get("https://jsonplaceholder.typicode.com/users")
        httpResponse.toResponse<List<UserDto>>()
    }

    override suspend fun getUser(id: Int): Response<UserDto> = withContext(Dispatchers.IO) {
        val httpResponse = client.get("https://jsonplaceholder.typicode.com/users/${id}")
        httpResponse.toResponse<UserDto>()
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> = withContext(Dispatchers.IO) {
        val httpResponse = client.post("https://jsonplaceholder.typicode.com/users") {
            contentType(ContentType.Application.Json)
            // 객체를 JSON으로 직렬화하여 본문에 포함
            //setBody(user)
            setBody(Json.encodeToString(user))  // 수동 직렬화
        }

        println(httpResponse.status)
        return@withContext httpResponse.toResponse<UserDto>()
    }
}
