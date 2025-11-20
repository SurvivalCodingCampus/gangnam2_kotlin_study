package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockTodoDataSourceImpl
import com.survival.kotlinstudy.day15.datasource.TodoDataSource
import com.survival.kotlinstudy.day15.model.Todo
import kotlinx.coroutines.runBlocking

class TodoRepositoryImpl(
    private val dataSource: TodoDataSource
) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return dataSource.getTodos().filter { it.completed }
    }

}

fun main() = runBlocking {
    val repository = TodoRepositoryImpl(MockTodoDataSourceImpl("data/todos.json"))

    println(repository.getTodos().size)
    println(repository.getCompletedTodos().any { it.completed })

}