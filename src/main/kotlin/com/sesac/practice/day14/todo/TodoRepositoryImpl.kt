package com.sesac.practice.day14.todo

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource,
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        val todos = todoDataSource.getTodos()

        return todos.filter { it.completed }
    }
}
