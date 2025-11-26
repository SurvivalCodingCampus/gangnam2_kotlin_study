package _251126_result.exercise2.data_source

import _251126_result.exercise2.core.HttpClientFactory
import _251126_result.exercise2.core.Response
import _251126_result.exercise2.model.User
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.net.ConnectException
import javax.naming.ServiceUnavailableException

class UserDataSourceImpl(
    private val httpClient: HttpClient = HttpClientFactory.generate()
) : UserDataSource {
    override suspend fun getAllUser(): Response<List<User>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = httpClient.get("testall.com")
                when (response.status) {
                    HttpStatusCode.OK -> {
                        //val result = (Json.decodeFromString<Response<List<UserDto>>>(response.bodyAsText()))
                        Response(
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
    }

    override suspend fun findUserById(id: Int): Response<String> {
        return withContext(Dispatchers.IO) {
            val response = httpClient.get("test/${id}.com")
            Response(status = response.status.toString(), body = response.bodyAsText(), header = "")
        }
    }

    override suspend fun createUser(user: User): Response<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = httpClient.post("test.com") {
                    setBody(Json.encodeToString(user))
                    contentType(ContentType.Application.Json)
                }
                if (response.status.isSuccess()) {
                    Response(body = user, status = response.status.toString(), "")
                } else {
                    throw ClientRequestException(response, "${response.status}")
                }
            } catch (e: ConnectException) { //클라이언트 관련 exception
                throw e
            } catch (e: ServiceUnavailableException) {//서버관련 exception
                throw e
            } catch (e: Exception) {
                throw e
            }
        }
    }
}