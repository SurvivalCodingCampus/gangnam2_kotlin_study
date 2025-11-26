package com.survival.kotlinstudy.day18.datasource

import com.survival.kotlinstudy.day18.core.Response
import com.survival.kotlinstudy.day18.dto.UserDto
import kotlinx.io.IOException

class MockNetworkErrorUserDataSourceImpl : UserDataSource {
    override suspend fun getUser(id: Int): Response<UserDto> {
        throw IOException("네트워크 연결 끊김")
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        throw IOException("네트워크 연결 끊김")
    }

    override suspend fun createUser(user: UserDto): Response<UserDto> {
        throw IOException("네트워크 연결 끊김")
    }
}