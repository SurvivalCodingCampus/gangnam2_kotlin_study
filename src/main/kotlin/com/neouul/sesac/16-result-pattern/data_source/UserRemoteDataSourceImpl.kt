package com.neouul.sesac.`16-result-pattern`.data_source

import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.util.toMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json

class UserRemoteDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : UserDataSource {

    // 디스패처 IO 설정했어요!!!
    // 코루틴의 withTimeout으로
    override suspend fun getUser(userId: Int): Response<UserDTO?> = withContext(Dispatchers.IO) {
        val response = withTimeout(10_000L) {
            client.get("$BASE_URL/users/$userId")
        }

        // 상태 코드 처리를 여기서 해주는게 맞을까..?
        // 그치만 안하면 body의 역직렬화에서 에러가 날텐데...
        if (!response.status.isSuccess()) {
            return@withContext Response(
                response.status.value,
                response.headers.toMap(),
                null
            )
        }

        Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(response.bodyAsText())
        )
    }

    override suspend fun getUsers(): Response<List<UserDTO?>?> = withContext(Dispatchers.IO) {
        val response = client.get("$BASE_URL/users")

        if (!response.status.isSuccess()) {
            return@withContext Response(
                response.status.value,
                response.headers.toMap(),
                null
            )
        }

        Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(response.bodyAsText())
        )
    }

    override suspend fun createUser(user: User): Response<UserDTO?> = withContext(Dispatchers.IO) {
        val response = client.post("$BASE_URL/users") {
            contentType(ContentType.Application.Json)   // 서버에 전송할 컨텐츠 설정
            setBody(Json.encodeToString(user))   // user 객체를 JSON으로 직렬화하여 본문에 포함
        }

        if (!response.status.isSuccess()) {
            return@withContext Response(
                response.status.value,
                response.headers.toMap(),
                null
            )
        }

        Response(
            response.status.value,
            response.headers.toMap(),
            Json.decodeFromString(response.bodyAsText())
        )
    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}