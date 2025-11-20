package _251120_test_double_model_class_repository.exercise4

interface UserDataSource {
    suspend fun getAllUser(): List<User>
}