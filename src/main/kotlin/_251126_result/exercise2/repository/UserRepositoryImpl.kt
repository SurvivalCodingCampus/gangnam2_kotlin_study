package _251126_result.exercise2.repository

import UserRepository
import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.data_source.UserDataSource
import _251126_result.exercise2.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.net.http.HttpTimeoutException

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun findUser(id: Int): Result<String, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(userDataSource.findUserById(id).body)
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
    }


    override suspend fun getAllUsers(): Result<List<User>, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(userDataSource.getAllUser().body)
            } catch (e: Exception) {
                Result.Error(NetworkError.Unknown("unknown"))
            }

        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun createUser(userString: String): Result<User, NetworkError> { //string으로 받아서 여기 메서드에서 parsing ->parsingError 사용해보려고 일부러 이렇게 짰음
        return withContext(Dispatchers.IO) {
            try {
                val user: User = Json.decodeFromString(userString)
                Result.Success(userDataSource.createUser(user).body)
            } catch (e: MissingFieldException) {
                Result.Error(NetworkError.ParseError)

            } catch (e: Exception) {
                Result.Error(NetworkError.Unknown("unknown"))
            }
        }
    }
}
