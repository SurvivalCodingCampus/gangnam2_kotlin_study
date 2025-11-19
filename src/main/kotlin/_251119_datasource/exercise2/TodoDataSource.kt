package _251119_datasource.exercise2

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}