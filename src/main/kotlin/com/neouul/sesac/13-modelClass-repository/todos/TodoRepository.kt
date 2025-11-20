package com.neouul.sesac.`13-modelClass-repository`.todos

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}

class TodoRepositoryImpl(
    private val dataSource: TodoDataSource,
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.loadTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return dataSource.loadTodos().filter { it.completed } // it.completed == true와 같은 뜻 (조건식)
    }
}