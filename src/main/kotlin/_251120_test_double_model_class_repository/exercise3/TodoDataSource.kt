package _251120_test_double_model_class_repository.exercise3

interface TodoDataSource {
    suspend fun getAllMemo(): List<Todo>
}