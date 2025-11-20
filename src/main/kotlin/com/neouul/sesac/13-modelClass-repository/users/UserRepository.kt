package com.neouul.sesac.`13-modelClass-repository`.users

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}

class UserRepositoryImpl(
    private val dataSource: UserDataSource,
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.loadUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return dataSource.loadUsers().sortedBy { it.name }.take(10)
    }
}