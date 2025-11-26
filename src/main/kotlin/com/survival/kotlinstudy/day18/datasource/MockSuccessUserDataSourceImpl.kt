package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto
import io.ktor.http.*

class MockSuccessUserDataSourceImpl : UserDataSource {
    val user1 = UserDto(id = 1, name = "홍길동")
    val user2 = UserDto(id = 2, name = "김이박")
    val user3 = UserDto(id = 3, name = "한석봉")
    override suspend fun getUser(id: Int): Response<UserDto> {
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = user1
        )
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        return Response(
            codeStatus = HttpStatusCode.OK.value,
            header = mapOf(),
            body = listOf(user1, user2, user3)
        )
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> {
        return Response(
            codeStatus = HttpStatusCode.Created.value,
            header = mapOf(),
            body = user1
        )
    }

}