package _251120_test_double_model_class_repository.exercise3

class TodoRepositoryImpl(private val todoDataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getAllMemo()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return todoDataSource.getAllMemo().filter { it.completed }
    }
}