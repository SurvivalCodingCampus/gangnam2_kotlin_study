package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.third

class TodoRepositoryImpl(val dataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodo()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        val todos = getTodos()

        return todos.filter { todo ->
            todo.completed
        }
    }
}