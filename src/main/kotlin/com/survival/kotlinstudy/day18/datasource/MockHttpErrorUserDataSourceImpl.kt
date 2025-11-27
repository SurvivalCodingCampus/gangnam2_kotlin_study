package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto

class MockHttpErrorUserDataSourceImpl(private val code: Int) : UserDataSource {
    override suspend fun getUser(id: Int): Response<UserDto> {
        return Response(codeStatus = code, header = mapOf(), body = UserDto())
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        return Response(codeStatus = code, header = mapOf(), body = listOf(UserDto()))
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> {
        return Response(codeStatus = code, header = mapOf(), body = UserDto())
    }
}