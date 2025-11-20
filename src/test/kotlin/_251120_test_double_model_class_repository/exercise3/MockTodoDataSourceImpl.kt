package _251120_test_double_model_class_repository.exercise3

class MockTodoDataSourceImpl : TodoDataSource {
    val mockTodoList = listOf(
        Todo(false, 1, "title1", 1),
        Todo(false, 2, "title2", 1),
        Todo(true, 3, "title3", 2),
        Todo(false, 4, "title4", 2),
    )

    override suspend fun getAllMemo(): List<Todo> {
        return mockTodoList
    }
}