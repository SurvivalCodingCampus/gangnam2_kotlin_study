package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto
import io.ktor.http.*
import kotlinx.coroutines.delay

class MockTimeOutUserDataSourceImpl : UserDataSource {
    override suspend fun getUser(id: Int): Response<UserDto> {
        delay(11_000L)
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = UserDto()
        )
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        delay(11_000L)
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = listOf(UserDto())
        )
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> {
        delay(11_000L)
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = UserDto()
        )
    }
}