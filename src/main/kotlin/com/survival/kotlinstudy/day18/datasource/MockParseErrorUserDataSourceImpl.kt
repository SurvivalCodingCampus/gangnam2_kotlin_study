package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto
import io.ktor.http.*
import kotlinx.serialization.json.Json

class MockParseErrorUserDataSourceImpl : UserDataSource {
    val json = """
        {
        "userName": "userName1"
        }
    """.trimIndent()

    override suspend fun getUser(id: Int): Response<UserDto> {
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = Json.decodeFromString(json)
        )
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = Json.decodeFromString(json)
        )
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> {
        return Response(
            codeStatus = HttpStatusCode.Created.value,
            header = mapOf(),
            body = Json.decodeFromString(json)
        )
    }

}