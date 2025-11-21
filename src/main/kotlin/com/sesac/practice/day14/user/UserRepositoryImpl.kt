package com.sesac.practice.day14.user

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return userDataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        val users = userDataSource.getUsers()

        return users.sortedBy { it.username }
            .take(10)
    }
}
