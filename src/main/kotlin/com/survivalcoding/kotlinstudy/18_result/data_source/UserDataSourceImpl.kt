package com.survivalcoding.kotlinstudy.`18_result`.data_source

import com.survivalcoding.kotlinstudy.`18_result`.core.HttpClientFactory
import com.survivalcoding.kotlinstudy.`18_result`.core.Response
import com.survivalcoding.kotlinstudy.`18_result`.dto.UserDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : UserDataSource {
    val baseUrl = "https://jsonplaceholder.typicode.com"

    // GET/ users/{id}
    override suspend fun getUser(id: Int): Response<UserDto> = withContext(Dispatchers.IO) {
        val response = client.get("$baseUrl/users/${id}")
        val body: UserDto? = response.body()

        Response(
            statusCode = response.status.value,
            headers = response.headers.toMap(),
            body = body
        )
    }

    // GET /users
    override suspend fun getUsers(): Response<List<UserDto>> = withContext(Dispatchers.IO) {
        val response = client.get("$baseUrl/users")
        val body: List<UserDto>? = response.body()

        Response(
            statusCode = response.status.value,
            headers = response.headers.toMap(),
            body = body
        )
    }

    // POST /users
    override suspend fun createUser(userDto: UserDto): Response<UserDto> = withContext(Dispatchers.IO) {
        val response = client.post("$baseUrl/users") {
            contentType(ContentType.Application.Json)
            setBody(userDto)
        }
        val body: UserDto? = response.body()

        Response(
            statusCode = response.status.value,
            headers = response.headers.toMap(),
            body = body
        )
    }

}