package com.neouul.sesac.`16-result-pattern`.repository

import com.neouul.sesac.`16-result-pattern`.core.NetworkError
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Result

interface UserRepository {
    suspend fun findUser(userId: Int): Result<User, NetworkError>
    suspend fun findAllUsers(): Result<List<User>, NetworkError>
    suspend fun createUser(user: User): Result<User, NetworkError>
}