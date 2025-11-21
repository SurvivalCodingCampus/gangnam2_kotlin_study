package com.ezlevup.my.day251120

import com.ezlevup.my.day251120.data_source.FileTodoDataSourceImpl
import com.ezlevup.my.day251120.data_source.MockTodoDataSourceImpl
import com.ezlevup.my.day251120.model.Todo
import com.ezlevup.my.day251120.repository.TodoRepositoryImpl
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val todoRepository = TodoRepositoryImpl(FileTodoDataSourceImpl())
    println(todoRepository.getTodos().count())
    println(todoRepository.getCompletedTodos().count())

    val todos = listOf(
        Todo(userId = 1, id = 1, title = "lee1", completed = true),
        Todo(userId = 1, id = 2, title = "lee2", completed = true),
    )
    TodoRepositoryImpl(MockTodoDataSourceImpl(todos)).getTodos().forEach { println(it) }
    TodoRepositoryImpl(MockTodoDataSourceImpl(todos)).getCompletedTodos().forEach { println(it) }
}