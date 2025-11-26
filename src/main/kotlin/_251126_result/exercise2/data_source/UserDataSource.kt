package _251126_result.exercise2.data_source

import _251126_result.exercise2.core.Response
import _251126_result.exercise2.model.User
import io.ktor.http.*

interface UserDataSource {
    suspend fun getAllUser(): Response<List<User>>
    suspend fun createUser(user: User): HttpStatusCode
}