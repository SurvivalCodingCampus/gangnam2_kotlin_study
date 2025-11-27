package com.survivalcoding.kotlinstudy.`18_result`.practice.repository

import com.survivalcoding.kotlinstudy.`18_result`.practice.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.mapper.mapNetworkError
import com.survivalcoding.kotlinstudy.`18_result`.practice.mapper.toDomain
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Result
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserById(id: Int): Result<User, NetworkError> {
        return try {
            val response: Response<UserDto> = dataSource.getUser(id)
            Result.Success(response.body.toDomain())
        } catch (e: Exception) {
            Result.Error(mapNetworkError(e))
        }
    }

    override suspend fun getAllUsers(): Result<List<User>, NetworkError> {
        return try {
            val response: Response<List<UserDto>> = dataSource.getUsers()
            Result.Success(response.body.map { it.toDomain() })
        } catch (e: Exception) {
            Result.Error(mapNetworkError(e))
        }
    }

    override suspend fun createUser(user: User): Result<User, NetworkError> {
        return try {
            val response = dataSource.createUser(user)
            Result.Success(response.body.toDomain())
        } catch (e: Exception) {
            Result.Error(mapNetworkError(e))
        }
    }
}