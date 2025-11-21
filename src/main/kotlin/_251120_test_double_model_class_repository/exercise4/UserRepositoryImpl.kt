package _251120_test_double_model_class_repository.exercise4

class UserRepositoryImpl(val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userDataSource.getAllUser()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return userDataSource.getAllUser().sortedBy { it.name }.take(10)
    }
}