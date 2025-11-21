package com.ezlevup.my.day251121


class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override suspend fun getTodo(id: Int): Todo {
        return todoDataSource.getTodo(id)
    }

    override suspend fun postTodo(newTodo: Todo): Todo {
        return todoDataSource.postTodo(newTodo)
    }

}
