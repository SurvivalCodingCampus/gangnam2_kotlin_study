package _251126_result.exercise2.data_source

import _251126_result.exercise2.core.Response
import _251126_result.exercise2.dto.UserDto
import _251126_result.exercise2.mapper.toModel
import _251126_result.exercise2.model.User
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class UserDataSourceImpl(
    private val httpClient: HttpClient
) : UserDataSource {
    override suspend fun getAllUser(): Response<List<User>> {
        return try {
            val response = httpClient.get("test.com")
            val result = (Json.decodeFromString<Response<List<UserDto>>>(response.bodyAsText()))
            Response(
                body = result.body.map { it.toModel() },
                status = result.status,
                header = result.header,
            )
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun createUser(user: User): HttpStatusCode {
        val response = httpClient.post("test.com") {
            setBody(user)
            contentType(ContentType.Application.Json)
        }
        return response.status
    }
}