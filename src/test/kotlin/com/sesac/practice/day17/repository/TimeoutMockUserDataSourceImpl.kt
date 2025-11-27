package com.sesac.practice.day17.repository

import com.sesac.practice.day17.core.Response
import com.sesac.practice.day17.datasource.UserDataSource
import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout

class TimeoutMockUserDataSourceImpl(
    private val timeMillis: Long,
) : UserDataSource {

    override suspend fun getUser(id: Long): Response<UserDto> {
        return withTimeout(timeMillis) {
            delay(timeMillis + 1)
            Response(200, mapOf())
        }
    }

    override suspend fun getUsers(): Response<List<UserDto>> {
        return withTimeout(timeMillis) {
            delay(timeMillis + 1)
            Response(200, mapOf())
        }
    }

    override suspend fun createUser(user: User): Response<UserDto> {
        return withTimeout(timeMillis) {
            delay(timeMillis + 1)
            Response(200, mapOf())
        }
    }
}
