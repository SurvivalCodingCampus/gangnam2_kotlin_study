package com.hhp227.kotlinstudy.`17_result`.repository

import com.hhp227.kotlinstudy.`17_result`.NetworkError
import com.hhp227.kotlinstudy.`17_result`.Result
import com.hhp227.kotlinstudy.`17_result`.User
import com.hhp227.kotlinstudy.`17_result`.datasource.UserDataSource
import kotlinx.serialization.SerializationException
import java.io.IOException
import java.net.SocketTimeoutException

class UserRepositoryImpl(
    private val dataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserById(id: Int): Result<User, NetworkError> {
        return try {
            val response = dataSource.getUserById(id)
            val user = response.data

            if (user != null) {
                Result.Success(user)
            } else {
                Result.Error(NetworkError.Unknown("user가 없습니다."))
            }
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: SocketTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "Unknown error"))
        }
    }

    override suspend fun getAllUsers(): Result<List<User>, NetworkError> {
        return try {
            val response = dataSource.getAllUsers()
            Result.Success(response.data)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: SocketTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "Unknown error"))
        }
    }

    override suspend fun addUser(user: User): Result<Boolean, NetworkError> {
        return try {
            val response = dataSource.addUser(user)
            Result.Success(response.data)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
        } catch (e: SocketTimeoutException) {
            Result.Error(NetworkError.Timeout)
        } catch (e: IOException) {
            Result.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown(e.message ?: "Unknown error"))
        }
    }
}