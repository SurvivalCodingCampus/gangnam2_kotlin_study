package com.survival.kotlinstudy.day18.repository

import com.survival.kotlinstudy.day18.datasource.UserDataSource
import com.survival.kotlinstudy.day18.dto.UserDto
import com.survival.kotlinstudy.day18.mapper.toModel
import com.survival.kotlinstudy.day18.model.User
import com.survival.kotlinstudy.day18.util.NetworkError
import com.survival.kotlinstudy.day18.util.Result
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {

    companion object {
        private const val TIMEOUT_MS = 10_000L
    }

    override suspend fun getUser(id: Int): Result<User, NetworkError> {
        return try {
            val response = withTimeout(TIMEOUT_MS) {
                dataSource.getUser(id)
            }

            when (response.codeStatus) {
                in 200..299 -> {
                    val body = response.body ?: return Result.Error(NetworkError.ParseError)

                    try {
                        Result.Success(body.toModel())
                    } catch (e: Exception) {
                        Result.Error(NetworkError.ParseError)
                    }
                }

                in 400..499 -> {
                    Result.Error(NetworkError.ClientError(response.codeStatus))
                }

                in 500..599 -> {
                    Result.Error(NetworkError.ServerError(response.codeStatus))
                }

                else -> Result.Error(NetworkError.HttpError(response.codeStatus))
            }
        } catch (e: TimeoutCancellationException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: ""))
        }
    }

    override suspend fun getUsers(): Result<List<User>, NetworkError> {
        return try {
            val response = withTimeout(TIMEOUT_MS) {
                dataSource.getUsers()
            }

            when (response.codeStatus) {
                in 200..299 -> {
                    val body = response.body ?: return Result.Error(NetworkError.ParseError)

                    try {
                        Result.Success(body.map { it.toModel() })
                    } catch (e: Exception) {
                        Result.Error(NetworkError.ParseError)
                    }
                }

                in 400..499 -> {
                    Result.Error(NetworkError.ClientError(response.codeStatus))
                }

                in 500..599 -> {
                    Result.Error(NetworkError.ServerError(response.codeStatus))
                }

                else -> Result.Error(NetworkError.HttpError(response.codeStatus))
            }
        } catch (e: TimeoutCancellationException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: ""))
        }

    }

    override suspend fun createUser(user: UserDto): Result<User, NetworkError> {
        return try {
            val response = withTimeout(TIMEOUT_MS) {
                dataSource.createUser(user)
            }

            when (response.codeStatus) {
                in 200..299 -> {
                    val body = response.body ?: return Result.Error(NetworkError.ParseError)

                    try {
                        Result.Success(body.toModel())
                    } catch (e: Exception) {
                        Result.Error(NetworkError.ParseError)
                    }
                }

                in 400..499 -> {
                    Result.Error(NetworkError.ClientError(response.codeStatus))
                }

                in 500..599 -> {
                    Result.Error(NetworkError.ServerError(response.codeStatus))
                }

                else -> Result.Error(NetworkError.HttpError(response.codeStatus))
            }
        } catch (e: TimeoutCancellationException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: ""))
        }
    }
}