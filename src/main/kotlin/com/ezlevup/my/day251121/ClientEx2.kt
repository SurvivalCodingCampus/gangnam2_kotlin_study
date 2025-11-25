package com.ezlevup.my.day251121

import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val todoRepository = TodoRepositoryImpl(TodoDataSourceImpl())
    todoRepository.getTodos().take(5).forEachIndexed { index, todo -> println("$index - ${todo.toString()}") }

    val newTodo = Todo(userId = 10, id = 20, title = "lee", completed = true)
    val result = todoRepository.postTodo(newTodo)
    println(result)

}
