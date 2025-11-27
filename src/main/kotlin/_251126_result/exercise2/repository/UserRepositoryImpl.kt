package _251126_result.exercise2.repository

import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.data_source.UserDataSource
import _251126_result.exercise2.model.User
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.net.ConnectException
import java.net.http.HttpTimeoutException
import javax.naming.ServiceUnavailableException

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun findUser(id: Int): Result<String, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                val response = userDataSource.findUserById(id)
                when (response.status) {
                    HttpStatusCode.OK.toString() -> {
                        return@withContext Result.Success(response.body)
                    }

                    HttpStatusCode.InternalServerError.toString() -> {
                        return@withContext Result.Error(NetworkError.HttpError(500))
                    }

                    HttpStatusCode.BadRequest.toString() -> {
                        return@withContext Result.Error(NetworkError.HttpError(400))
                    }

                    else -> {
                        return@withContext Result.Error(NetworkError.Unknown("status: ${response.status}"))
                    }
                }
            } catch (e: TimeoutCancellationException) { //타임아웃 관련
                Result.Error(NetworkError.TimeOut)
            } catch (e: ServiceUnavailableException) {//서버관련 exception
                Result.Error(NetworkError.HttpError(500))
            } catch (e: HttpTimeoutException) {
                Result.Error(NetworkError.TimeOut)
            } catch (e: SerializationException) {
                Result.Error(NetworkError.ParseError)
            } catch (e: ConnectException) { //클라이언트 관련 exception
                Result.Error(NetworkError.HttpError(400))
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
