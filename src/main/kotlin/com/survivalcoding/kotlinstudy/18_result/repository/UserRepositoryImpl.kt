package com.survivalcoding.kotlinstudy.`18_result`.repository

import com.survivalcoding.kotlinstudy.`18_result`.core.NetworkError
import com.survivalcoding.kotlinstudy.`18_result`.core.Result
import com.survivalcoding.kotlinstudy.`18_result`.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`18_result`.mapper.toCreateRequestDto
import com.survivalcoding.kotlinstudy.`18_result`.mapper.toModel
import com.survivalcoding.kotlinstudy.`18_result`.model.User
import io.ktor.client.plugins.*
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException
import java.net.UnknownHostException

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {

    // GET /users/{id}
    override suspend fun getUser(id: Int): Result<User, NetworkError> {
        return try {
            val response = dataSource.getUser(id)

            // HTTP 상태 코드에 따른 분기 처리
            when (response.statusCode) {
                in 200..299 -> {
                    // 성공 (2xx)
                    val userDto = response.body
                    if (userDto == null || userDto.name.isNullOrBlank()) {
                        return Result.Error(NetworkError.ParseError) // 없는 아이디를 요청한경우 {} 빈 본문
                    } else {
                        Result.Success(userDto.toModel())
                    }
                }

                else -> {
                    // 에러 (4xx, 5xx)
                    Result.Error(NetworkError.HttpError(response.statusCode))
                }
            }
        } catch (e: HttpRequestTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: UnknownHostException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "알 수 없는 에러 발생"))
        }
    }

    // GET /users
    override suspend fun getUsers(): Result<List<User>, NetworkError> {
        return try {
            val response = dataSource.getUsers()

            // HTTP 상태 코드에 따른 분기 처리
            when (response.statusCode) {
                in 200..299 -> {
                    // 성공 (2xx)
                    val userDtoList = response.body
                        ?: return Result.Error(NetworkError.ParseError) // 응답 본문 비어서 받을 일 없지만 nullable 처리

                    Result.Success(userDtoList.map { it.toModel() })
                }

                else -> {
                    // 에러 (4xx, 5xx 등)
                    Result.Error(NetworkError.HttpError(response.statusCode))
                }
            }
        } catch (e: HttpRequestTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: UnknownHostException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "알 수 없는 에러 발생"))
        }
    }

    // POST /users
    override suspend fun createUser(user: User): Result<Int, NetworkError> {
        return try {
            // Model을 DTO로 변환
            val requestDto = user.toCreateRequestDto()

            val response = dataSource.createUser(requestDto) // 서버에 POST 요청

            // HTTP 상태 코드에 따른 분기 처리
            when (response.statusCode) {
                in 200..299 -> {
                    val id = response.body
                        ?: return Result.Error(NetworkError.ParseError)

                    Result.Success(id)   // id 만 반환
                }

                else -> {
                    // 에러 (4xx, 5xx 등)
                    Result.Error(NetworkError.HttpError(response.statusCode))
                }
            }
        } catch (e: HttpRequestTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: UnknownHostException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "알 수 없는 에러 발생"))
        }
    }
}