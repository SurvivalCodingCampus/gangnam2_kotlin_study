package com.sesac.practice.day17.repository

import com.sesac.practice.day17.core.NetworkError
import com.sesac.practice.day17.core.NetworkError.HttpError
import com.sesac.practice.day17.core.Result
import com.sesac.practice.day17.core.isFail
import com.sesac.practice.day17.datasource.UserDataSource
import com.sesac.practice.day17.dto.UserDto
import com.sesac.practice.day17.mapper.toModel
import com.sesac.practice.day17.model.User
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

class UserRepositoryImpl(
    private val dataSource: UserDataSource,
) : UserRepository {

    override suspend fun getUser(id: Long): Result<User, NetworkError> =
        runCatching {
            val response = dataSource.getUser(id)

            if (response.isFail()) {
                return@runCatching Result.Error(HttpError(response.statusCode))
            }

            val user = response.body.toModel() ?: return@runCatching Result.Error(NetworkError.Unknown("잘못된 사용자입니다"))

            Result.Success(user)
        }

    override suspend fun getUsers(): Result<List<User>, NetworkError> =
        runCatching {
            val response = dataSource.getUsers()

            if (response.isFail()) {
                return@runCatching Result.Error(HttpError(response.statusCode))
            }

            val users = response.body?.mapNotNull(UserDto::toModel).orEmpty()

            Result.Success(users)
        }

    override suspend fun createUser(user: User): Result<User, NetworkError> =
        runCatching {
            val response = dataSource.createUser(user)

            if (response.isFail()) {
                return@runCatching Result.Error(HttpError(response.statusCode))
            }

            val user = response.body.toModel() ?: return@runCatching Result.Error(NetworkError.Unknown("잘못된 사용자입니다"))

            Result.Success(user)
        }

    private suspend fun <T> runCatching(block: suspend () -> Result<T, NetworkError>): Result<T, NetworkError> =
        try {
            block()
        } catch (_: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (_: TimeoutCancellationException) {
            Result.Error(NetworkError.Timeout)
        } catch (_: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (_: Exception) {
            Result.Error(NetworkError.Unknown("에러가 발생했습니다"))
        }
}
