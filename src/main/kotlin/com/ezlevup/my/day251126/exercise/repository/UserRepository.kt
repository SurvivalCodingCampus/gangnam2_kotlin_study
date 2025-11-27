package com.ezlevup.my.day251126.exercise.repository

import com.ezlevup.my.core.RepositoryResult
import com.ezlevup.my.day251126.exercise.model.NetworkError
import com.ezlevup.my.day251126.exercise.model.User

interface UserRepository {
    suspend fun getUser(id: Int): RepositoryResult<User, NetworkError>
    suspend fun getUsers(): RepositoryResult<List<User>, NetworkError>
    suspend fun createUser(user: User): RepositoryResult<User, NetworkError>
}
