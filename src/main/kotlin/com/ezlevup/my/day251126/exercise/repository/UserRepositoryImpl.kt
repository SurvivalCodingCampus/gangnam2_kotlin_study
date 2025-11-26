package com.ezlevup.my.day251126.exercise.repository

import com.ezlevup.my.core.RepositoryResult
import com.ezlevup.my.day251126.exercise.data_source.UserDataSource
import com.ezlevup.my.day251126.exercise.data_source.UserDataSourceImpl
import com.ezlevup.my.day251126.exercise.mapper.toUser
import com.ezlevup.my.day251126.exercise.mapper.toUserDto
import com.ezlevup.my.day251126.exercise.model.NetworkError
import com.ezlevup.my.day251126.exercise.model.User
import io.ktor.client.plugins.*
import io.ktor.network.sockets.*
import kotlinx.io.IOException

class UserRepositoryImpl(
    val userDataSource: UserDataSource = UserDataSourceImpl()
) : UserRepository {

    override suspend fun getUser(id: Int): RepositoryResult<User, NetworkError> {
        return try {
            val response = userDataSource.getUser(id)

            val statusValue = response.status.value
            when (statusValue) {
                in 400..499 -> return RepositoryResult.Error(NetworkError.HttpClientError(statusValue))
                in 500..599 -> return RepositoryResult.Error(NetworkError.HttpServerError(statusValue))
                !in 200..299 -> return RepositoryResult.Error(NetworkError.HttpError(statusValue))
            }

            if (response.body != null) {
                val user = response.body.toUser()
                RepositoryResult.Success(user)
            } else {
                RepositoryResult.Error(NetworkError.ParseError)
            }
        } catch (e: HttpRequestTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        } catch (e: SocketTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        } catch (e: IOException) {
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            println(e.toString())
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        }
    }

    override suspend fun getUsers(): RepositoryResult<List<User>, NetworkError> {
        return try {
            val response = userDataSource.getUsers()
            if (response.body != null) {
                val users = response.body.map { it.toUser() }
                RepositoryResult.Success(users)
            } else {
                RepositoryResult.Error(NetworkError.NetworkUnavailable)
            }
        } catch (e: IOException) {
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        } catch (e: SocketTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        }
    }

    override suspend fun createUser(user: User): RepositoryResult<User, NetworkError> {
        return try {
            val response = userDataSource.createUser(user.toUserDto())
            if (response.body != null) {
                val userDto = response.body
                RepositoryResult.Success(userDto.toUser())
            } else {
                RepositoryResult.Error(NetworkError.NetworkUnavailable)
            }
        } catch (e: IOException) {
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        } catch (e: SocketTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        }
    }
}
