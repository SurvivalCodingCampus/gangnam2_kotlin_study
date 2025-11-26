import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.model.User
import io.ktor.http.*


interface UserRepository {
    suspend fun findUser(id: Int): Result<User?, NetworkError>
    suspend fun getAllUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: User): Result<HttpStatusCode, NetworkError>
}