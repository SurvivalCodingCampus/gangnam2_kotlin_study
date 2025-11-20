package _251120_test_double_model_class_repository.exercise4

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}