package _251126_result.exercise2.repository

import UserRepository
import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.data_source.UserDataSource
import _251126_result.exercise2.model.User
import io.ktor.http.*
import java.net.http.HttpTimeoutException
import java.util.concurrent.TimeoutException

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun findUser(id: Int): Result<User?, NetworkError> {
        return try {
            val tmp = Result.Success(userDataSource.getAllUser().body.find { it.id == id })
            tmp
        } catch (e: NullPointerException) {
            Result.Error(NetworkError.UserNotFoundError)
        } catch (e: TimeoutException) {
            Result.Error(NetworkError.TimeOut)
        } catch (e: HttpTimeoutException) {
            Result.Error(NetworkError.TimeOut)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown("unknown"))
        }
    }

    override suspend fun getAllUsers(): Result<List<User>, NetworkError> {
        return try {
            Result.Success(userDataSource.getAllUser().body)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown("unknown"))
        }

    }

    override suspend fun createUser(user: User): Result<HttpStatusCode, NetworkError> {
        return try {
            Result.Success(userDataSource.createUser(user))
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown("unknown"))
        }
    }
}
