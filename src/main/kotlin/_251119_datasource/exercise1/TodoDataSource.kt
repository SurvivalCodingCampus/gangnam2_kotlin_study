package _251119_datasource.exercise1

interface TodoDataSource {
    suspend fun getTodo(): Todo
}