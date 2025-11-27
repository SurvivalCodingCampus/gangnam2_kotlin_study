package com.sesac.practice.day17.repository

import com.sesac.practice.day17.core.Response
import com.sesac.practice.day17.datasource.UserDataSource
import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.model.User
import kotlinx.serialization.json.Json

class ParseErrorMockUserDataSourceImpl() : UserDataSource {
    private val invalidJson = """
            {
              "invalid": "json"
            }
        """.trimIndent()

    override suspend fun getUser(id: Long): Response<UserDto> {
        return Response(
            200,
            mapOf(),
            Json.decodeFromString(invalidJson),
        )
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        return Response(
            200,
            mapOf(),
            Json.decodeFromString(invalidJson),
        )
    }

    override suspend fun createUser(user: User): Response<UserDto> {
        return Response(
            200,
            mapOf(),
            Json.decodeFromString(invalidJson),
        )
    }
}
