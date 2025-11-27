package com.ezlevup.my.day251126.exercise.repository

import com.ezlevup.my.core.RepositoryResult
import com.ezlevup.my.core.Response
import com.ezlevup.my.day251126.exercise.data_source.UserDataSource
import com.ezlevup.my.day251126.exercise.data_source.UserDataSourceImpl
import com.ezlevup.my.day251126.exercise.mapper.toUser
import com.ezlevup.my.day251126.exercise.mapper.toUserDto
import com.ezlevup.my.day251126.exercise.model.NetworkError
import com.ezlevup.my.day251126.exercise.model.User
import io.ktor.client.plugins.*
import org.slf4j.LoggerFactory

class UserRepositoryImpl(
    private val userDataSource: UserDataSource = UserDataSourceImpl()
) : UserRepository {
    companion object {
        private val logger = LoggerFactory.getLogger(UserRepositoryImpl::class.java)
    }

    private suspend fun <T, R> executeWithErrorHandling(
        block: suspend () -> Response<T>,
        mapper: (T) -> R
    ): RepositoryResult<R, NetworkError> {
        return try {
            val response = block()

            val statusValue = response.status.value
            when (statusValue) {
                in 400..499 -> return RepositoryResult.Error(NetworkError.HttpClientError(statusValue))
                in 500..599 -> return RepositoryResult.Error(NetworkError.HttpServerError(statusValue))
                !in 200..299 -> return RepositoryResult.Error(NetworkError.HttpError(statusValue))
            }

            if (response.body != null) {
                val result = mapper(response.body)
                RepositoryResult.Success(result)
            } else {
                RepositoryResult.Error(NetworkError.ParseError)
            }
        } catch (e: HttpRequestTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        } catch (e: java.net.SocketTimeoutException) {
            RepositoryResult.Error(NetworkError.Timeout)
        } catch (e: java.io.IOException) {
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        } catch (e: Exception) {
            logger.error("Unexpected error during repository operation", e)
            RepositoryResult.Error(NetworkError.NetworkUnavailable)
        }
    }


    override suspend fun getUser(id: Int): RepositoryResult<User, NetworkError> {
        return executeWithErrorHandling(
            block = { userDataSource.getUser(id) },
            mapper = { it.toUser() }
        )
    }

    override suspend fun getUsers(): RepositoryResult<List<User>, NetworkError> {
        return executeWithErrorHandling(
            block = { userDataSource.getUsers() },
            mapper = { it.map { dto -> dto.toUser() } }
        )
    }

    override suspend fun createUser(user: User): RepositoryResult<User, NetworkError> {
        return executeWithErrorHandling(
            block = { userDataSource.createUser(user.toUserDto()) },
            mapper = { it.toUser() }
        )
    }
}
