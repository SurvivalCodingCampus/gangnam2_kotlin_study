package com.luca.kotlinstudy._18_result.datasource

import com.luca.kotlinstudy._18_result.dto.UserDTO
import com.luca.kotlinstudy.core.HttpClientFactory
import com.luca.kotlinstudy.core.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.toMap

class UserDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : UserDataSource {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/users"
    }

    override suspend fun findById(userId: String): Response<UserDTO> {
        val httpResponse = client.get("$BASE_URL/$userId")
        val dto = httpResponse.body<UserDTO>()

        return Response(
            statusCode = httpResponse.status.value,
            headers = httpResponse.headers.toMap(),
            body = dto
        )
    }

    override suspend fun findAll(): Response<List<UserDTO>> {
        val httpResponse = client.get(BASE_URL)

        val dtoList: List<UserDTO> = httpResponse.body()

        return Response(
            statusCode = httpResponse.status.value,
            headers = httpResponse.headers.toMap(),
            body = dtoList
        )
    }

    override suspend fun create(user: UserDTO): Response<UserDTO> {
        val httpResponse = client.post(BASE_URL) {
            contentType(ContentType.Application.Json)
            setBody(user)
        }

        val dto = httpResponse.body<UserDTO>()

        return Response(
            statusCode = httpResponse.status.value,
            headers = httpResponse.headers.toMap(),
            body = dto
        )
    }
}
