package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

class UserRepositoryImpl(val dataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUser()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        val topLimit = 10
        val users = getUsers()

        return users.sortedBy { user ->
                user.username
            }
            .take(topLimit)
    }
}