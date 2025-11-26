package _251126_result.exercise2.data_source

import _251126_result.exercise2.core.HttpClientFactory
import _251126_result.exercise2.core.Response
import _251126_result.exercise2.model.User
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import javax.naming.ServiceUnavailableException

class UserDataSourceImpl(
    private val httpClient: HttpClient = HttpClientFactory.generate()
) : UserDataSource {
    override suspend fun getAllUser(): Response<List<User>> {
        try {
            val response = httpClient.get("testall.com")
            when (response.status) {
                HttpStatusCode.OK -> {
                    //val result = (Json.decodeFromString<Response<List<UserDto>>>(response.bodyAsText()))
                    return Response(
                        body = Json.decodeFromString<List<User>>(response.bodyAsText()),
                        status = response.status.toString(),
                        header = "",
                    )
                }

                HttpStatusCode.InternalServerError -> {
                    throw ServiceUnavailableException()
                }

                HttpStatusCode.NotFound -> {
                    throw ClientRequestException(response, "")
                }

                else -> {
                    throw Exception()
                }
            }

        } catch (e: ServiceUnavailableException) {
            throw e

        } catch (e: ClientRequestException) {
            throw ClientRequestException(e.response, e.message)

        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun createUser(user: User): Response<User> {
        val response = httpClient.post("test.com") {
            setBody(Json.encodeToString(user))
            contentType(ContentType.Application.Json)
        }
        return Response(body = user, status = response.status.toString(), "")
    }
}