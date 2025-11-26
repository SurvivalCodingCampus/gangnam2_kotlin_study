package com.hhp227.kotlinstudy.`17_result`.datasource

import com.hhp227.kotlinstudy.`17_result`.User
import com.hhp227.kotlinstudy.`17_result`.Response
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class UserDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
) : UserDataSource {
    override suspend fun getUserById(id: Int): Response<User?> {
        val response = client.get("${URL}/$id")
        return if (!response.status.isSuccess())
            Response(response.status.value, response.headers, null)
        else Response(
            response.status.value,
            response.headers,
            response.body<User?>()
        )
    }

    override suspend fun getAllUsers(): Response<List<User>> {
        val response = client.get("${URL}/all")
        return if (!response.status.isSuccess())
            Response(response.status.value, response.headers, emptyList())
        else Response(
            response.status.value,
            response.headers,
            response.body<List<User>>()
        )
    }

    override suspend fun addUser(user: User): Response<Boolean> {
        val response = client.post(URL)
        return if (!response.status.isSuccess())
            Response(response.status.value, response.headers, false)
        else Response(
            response.status.value,
            response.headers,
            response.body()
        )
    }

    companion object {
        const val URL = "http://test.com"
    }
}