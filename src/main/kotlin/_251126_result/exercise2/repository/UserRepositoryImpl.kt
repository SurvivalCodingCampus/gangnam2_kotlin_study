package _251126_result.exercise2.repository

import UserRepository
import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.data_source.UserDataSource
import _251126_result.exercise2.model.User
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.serialization.SerializationException
import java.net.http.HttpTimeoutException

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun findUser(id: Int): Result<User?, NetworkError> {
        return try {
            Result.Success(userDataSource.getAllUser().body.find { it.id == id })

        } catch (e: NullPointerException) {
            Result.Error(NetworkError.UserNotFoundError)
        } catch (e: TimeoutCancellationException) { //타임아웃 관련
            Result.Error(NetworkError.TimeOut)
        } catch (e: HttpTimeoutException) {
            Result.Error(NetworkError.TimeOut)
        } catch (e: SerializationException) {
            Result.Error(NetworkError.ParseError)
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

    override suspend fun createUser(user: User): Result<User, NetworkError> {
        return try {
            Result.Success(userDataSource.createUser(user).body)
        } catch (e: Exception) {
            Result.Error(NetworkError.Unknown("unknown"))
        }
    }
}
