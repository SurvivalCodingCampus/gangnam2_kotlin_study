package com.luca.kotlinstudy._15_model_repository

import com.luca.kotlinstudy._15_model_repository.Path.COMMENT_PATH
import com.luca.kotlinstudy._15_model_repository.Path.PHOTO_PATH
import com.luca.kotlinstudy._15_model_repository.Path.TODO_PATH
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.FileCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.MockCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.FilePhotoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.MockPhotoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.todo.FileTodoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.todo.MockTodoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.repository.comment.CommentRepository
import com.luca.kotlinstudy._15_model_repository.repository.comment.CommentRepositoryImpl
import com.luca.kotlinstudy._15_model_repository.repository.photo.PhotoRepository
import com.luca.kotlinstudy._15_model_repository.repository.photo.PhotoRepositoryImpl
import com.luca.kotlinstudy._15_model_repository.repository.todo.TodoRepository
import com.luca.kotlinstudy._15_model_repository.repository.todo.TodoRepositoryImpl
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // comment
    printComments(
        label = "Comment (File)",
        repository = CommentRepositoryImpl(FileCommentDatasourceImpl(COMMENT_PATH))
    )
    printComments(
        label = "Comment (Mock)",
        repository = CommentRepositoryImpl(MockCommentDatasourceImpl())
    )

    // photo
    printPhotos(
        label = "Photo (File)",
        repository = PhotoRepositoryImpl(FilePhotoDatasourceImpl(PHOTO_PATH))
    )
    printPhotos(
        label = "Photo (Mock)",
        repository = PhotoRepositoryImpl(MockPhotoDatasourceImpl())
    )

    // todo
    printTodos(
        label = "Todo (File)",
        repository = TodoRepositoryImpl(FileTodoDatasourceImpl(TODO_PATH))
    )
    printTodos(
        label = "Todo (Mock)",
        repository = TodoRepositoryImpl(MockTodoDatasourceImpl())
    )
}

// 공통 경로 상수
object Path {
    private const val COMMON_PATH =
        "src/main/kotlin/com/luca/kotlinstudy/_15_model_repository/dataSource/"

    const val COMMENT_PATH = COMMON_PATH + "comment/comments.json"
    const val PHOTO_PATH = COMMON_PATH + "photo/photos.json"
    const val TODO_PATH = COMMON_PATH + "todo/todos.json"
}

// 출력 헬퍼들

private suspend fun printComments(
    label: String,
    repository: CommentRepository
) {
    println("===== $label =====")
    val comments = repository.getComments(1)
    println(comments)
    println("----------------------------------------")
}

private suspend fun printPhotos(
    label: String,
    repository: PhotoRepository
) {
    println("===== $label =====")
    val photos = repository.getPhotos(1)
    println(photos)
    println("----------------------------------------")
}

private suspend fun printTodos(
    label: String,
    repository: TodoRepository
) {
    println("===== $label =====")
    val todos = repository.getTodos()
    println(todos)

    val completed = repository.getCompletedTodos()
    println(completed)

    println("----------------------------------------")
}
