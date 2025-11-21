package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.todo

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Todo

class MockTodoDataSourceImpl : TodoDataSource {

    private val mockTodos = listOf(
        Todo(
            userId = 1,
            id = 1,
            title = "delectus aut autem",
            completed = false
        ),
        Todo(
            userId = 1,
            id = 2,
            title = "quis ut nam facilis et officia qui",
            completed = false
        ),
        Todo(
            userId = 1,
            id = 3,
            title = "fugiat veniam minus",
            completed = false
        ),
        Todo(
            userId = 2,
            id = 4,
            title = "et porro tempora",
            completed = true
        ),
        Todo(
            userId = 2,
            id = 5,
            title = "laboriosam mollitia et enim quasi adipisci quia provident illum",
            completed = false
        )
    )

    override suspend fun getTodos(): List<Todo> = mockTodos
}
