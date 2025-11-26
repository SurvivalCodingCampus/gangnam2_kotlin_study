import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.model.User


interface UserRepository {
    suspend fun findUser(id: Int): Result<String, NetworkError>
    suspend fun getAllUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(userString: String): Result<User, NetworkError>
}