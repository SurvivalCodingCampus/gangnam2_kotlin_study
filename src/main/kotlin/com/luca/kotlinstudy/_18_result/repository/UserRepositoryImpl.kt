package com.luca.kotlinstudy._18_result.repository

import com.luca.kotlinstudy._18_result.datasource.UserDataSource
import com.luca.kotlinstudy._18_result.dto.UserDTO
import com.luca.kotlinstudy._18_result.mapper.toDTO
import com.luca.kotlinstudy._18_result.mapper.toUser
import com.luca.kotlinstudy._18_result.mapper.toUsers
import com.luca.kotlinstudy.core.Result
import com.luca.kotlinstudy.core.NetworkError
import com.luca.kotlinstudy._18_result.model.User
import com.luca.kotlinstudy.core.Response
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.serialization.SerializationException
import java.io.IOException

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {

    override suspend fun findById(userId: String): UserResult<User> {
        return try {
            val response = dataSource.findById(userId)

            if (response.isSuccess()) {
                val dto: UserDTO = response.body
                    ?: return Result.Failure(NetworkError.ParseError)

                Result.Success(dto.toUser())
            } else {
                Result.Failure(NetworkError.HttpError(response.statusCode))
            }

        } catch (e: Exception) {
            errors(e)
        }
    }

    override suspend fun findAll(): UserResult<List<User>> {
        return try {
            val response = dataSource.findAll()

            if (response.isSuccess()) {
                val dtoList: List<UserDTO> = response.body
                    ?: return Result.Failure(NetworkError.ParseError)

                Result.Success(dtoList.toUsers())
            } else {
                Result.Failure(NetworkError.HttpError(response.statusCode))
            }

        } catch (e: Exception) {
            errors(e)
        }
    }

    override suspend fun create(user: User): UserResult<User> {
        return try {
            val response = dataSource.create(user.toDTO())

            if (response.isSuccess()) {
                val dto = response.body!!
                Result.Success(dto.toUser())
            } else {
                Result.Failure(NetworkError.HttpError(response.statusCode))
            }

        } catch (e: Exception) {
            errors(e)
        }
    }

}

private fun <T> Response<T>.isSuccess(): Boolean =
    this.statusCode in 200..299

private fun <T> errors(e: Exception): UserResult<T> {

    return when (e) {
        is HttpRequestTimeoutException ->
            Result.Failure(NetworkError.Timeout)

        is SerializationException ->
            Result.Failure(NetworkError.ParseError)

        is IOException ->
            Result.Failure(NetworkError.NetworkUnavailable)

        else ->
            Result.Failure(NetworkError.Unknown(e.message ?: "Unknown Error"))
    }

}
