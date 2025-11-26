package com.neouul.sesac.`16-result-pattern`.repository

import com.neouul.sesac.`16-result-pattern`.core.NetworkError
import com.neouul.sesac.`16-result-pattern`.data_source.UserDataSource
import com.neouul.sesac.`16-result-pattern`.mapper.toModel
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Result
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.serialization.SerializationException

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {

    // 사용자 ID로 단일 사용자 조회
    override suspend fun findUser(userId: Int): Result<User, NetworkError> {
        try {
            val response = dataSource.getUser(userId)

            return if (response.body != null) {
                Result.Success(
                    response.body.toModel()
                )
            } else {    // 상태 코드가 200번대가 아닌 상황 처리
                val statusCode = response.statusCode
                when (statusCode) {
                    in 400..599 -> Result.Error(NetworkError.HttpError(statusCode))
                    else -> Result.Error(NetworkError.Unknown("상태 코드 : $statusCode"))
                }
            }
        } catch (e: TimeoutCancellationException) {
            return Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.ParseError)
        } catch (e: Exception) {
            return Result.Error(NetworkError.NetworkUnavailable)    // 네트워크 연결 안됨
        }
    }

    // 전체 사용자 목록 조회
    override suspend fun findAllUsers(): Result<List<User>, NetworkError> {
        try {
            val response = dataSource.getUsers()

            return if (response.body != null) {
                Result.Success(
                    response.body.filterNotNull()
                        .filter { it.id != null && it.name != null && it.username != null }
                        .map { it.toModel() }
                )
            } else {
                val statusCode = response.statusCode
                when (statusCode) {
                    in 400..599 -> Result.Error(NetworkError.HttpError(statusCode))
                    else -> Result.Error(NetworkError.Unknown("상태 코드 : $statusCode"))
                }
            }
        } catch (e: TimeoutCancellationException) {
            return Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.ParseError)
        } catch (e: Exception) {
            return Result.Error(NetworkError.NetworkUnavailable)
        }
    }

    // 새 사용자 생성
    override suspend fun createUser(user: User): Result<User, NetworkError> {
        try {
            val response = dataSource.createUser(user)

            return if (response.body != null) {
                Result.Success(
                    response.body.toModel()
                )
            } else {
                val statusCode = response.statusCode
                when (statusCode) {
                    in 400..599 -> Result.Error(NetworkError.HttpError(statusCode))
                    else -> Result.Error(NetworkError.Unknown("상태 코드 : $statusCode"))
                }
            }
        } catch (e: TimeoutCancellationException) {
            return Result.Error(NetworkError.Timeout)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.ParseError)
        } catch (e: Exception) {
            return Result.Error(NetworkError.NetworkUnavailable)
        }
    }

}