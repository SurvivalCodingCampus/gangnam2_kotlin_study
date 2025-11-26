package com.survivaalcoding.kotlinstudy.`17_result`.example.repository

import com.survivaalcoding.kotlinstudy.`17_result`.example.core.Result
import com.survivaalcoding.kotlinstudy.`17_result`.example.datasource.DataSource
import com.survivaalcoding.kotlinstudy.`17_result`.example.dto.UserDto
import com.survivaalcoding.kotlinstudy.`17_result`.example.exception.NetworkError
import com.survivaalcoding.kotlinstudy.`17_result`.example.mapper.toModel
import com.survivaalcoding.kotlinstudy.`17_result`.example.model.User
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.withTimeout
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

class UserRepositoryImpl(private val dataSource: DataSource) : UserRepository {
    override suspend fun findAll(): Result<List<User>, NetworkError> {
        return try {
            withTimeout(10_000) {
                val result = dataSource.findAll().body ?: emptyList()

                result.filter { it.id != null }
                    .map { it.toModel() }
                    .let { Result.Success(it) }
            }
        } catch (e: IOException) {
            Result.Failure(NetworkError.NetworkUnavailable)
        } catch (e: CancellationException) {
            Result.Failure(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Failure(NetworkError.ParseError)
        } catch (e: Exception) {
            Result.Failure(NetworkError.Unknown(e.message ?: "알 수 없는 오류입니다."))
        }
    }

    override suspend fun findById(id: Long): Result<User, NetworkError> {
        return try {
            withTimeout(10_000) {
                val result = dataSource.findById(id).body
                if (result == null || result.id == null) {
                    return@withTimeout Result.Failure(NetworkError.HttpError(404))
                }

                Result.Success(result.toModel())
            }
        } catch (e: IOException) {
            Result.Failure(NetworkError.NetworkUnavailable)
        } catch (e: CancellationException) {
            Result.Failure(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Failure(NetworkError.ParseError)
        } catch (e: Exception) {
            Result.Failure(NetworkError.Unknown(e.message ?: "알 수 없는 오류입니다."))
        }
    }

    override suspend fun save(userDto: UserDto): Result<Long, NetworkError> {
        return try {
            withTimeout(10_000) {
                val result = dataSource.save(userDto).body
                if (result == null || result.id == null) {
                    return@withTimeout Result.Failure(NetworkError.HttpError(500))
                }

                Result.Success(result.id)
            }
        } catch (e: IOException) {
            Result.Failure(NetworkError.NetworkUnavailable)
        } catch (e: CancellationException) {
            Result.Failure(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Failure(NetworkError.ParseError)
        } catch (e: Exception) {
            Result.Failure(NetworkError.Unknown(e.message ?: "알 수 없는 오류입니다."))
        }
    }
}