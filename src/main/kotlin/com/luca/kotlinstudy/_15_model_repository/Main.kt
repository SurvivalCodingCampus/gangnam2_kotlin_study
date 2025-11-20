package com.luca.kotlinstudy._15_model_repository

import com.luca.kotlinstudy._15_model_repository.Main.Companion.COMMENT_PATH
import com.luca.kotlinstudy._15_model_repository.Main.Companion.PHOTO_PATH
import com.luca.kotlinstudy._15_model_repository.Main.Companion.TODO_PATH
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.FileCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.MockCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.FilePhotoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.photo.MockPhotoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.todo.FileTodoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.dataSource.todo.MockTodoDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.repository.comment.CommentRepositoryImpl
import com.luca.kotlinstudy._15_model_repository.repository.photo.PhotoRepositoryImpl
import com.luca.kotlinstudy._15_model_repository.repository.todo.TodoRepositoryImpl
import kotlinx.coroutines.runBlocking

/*
[main] -> [CommentRepository]-> [CommentRepositoryImpl] -> [CommentDataSource] -> [MockCommentDataSourceImpl]
-> [comments.json 읽기] -> [List<Comment>] 반환
 */
fun main() = runBlocking {
    // comment
    val commentDatasource = FileCommentDatasourceImpl(COMMENT_PATH)
    val commentRepository = CommentRepositoryImpl(commentDatasource)
    val comments = commentRepository.getComments(1)
    println(comments)
    println("----------------------------------------")
    val mockDataSource = MockCommentDatasourceImpl()
    val mockCommonRepository = CommentRepositoryImpl(mockDataSource)
    val mockComments = mockCommonRepository.getComments(1)
    println(mockComments)
    println("----------------------------------------")

    // photo
    val photoDataSource = FilePhotoDatasourceImpl(PHOTO_PATH)
    val photoRepository = PhotoRepositoryImpl(photoDataSource)
    val photos = photoRepository.getPhotos(1)
    println(photos)
    println("----------------------------------------")
    val mockPhotoDatasource = MockPhotoDatasourceImpl()
    val mockPhotoRepository = PhotoRepositoryImpl(mockPhotoDatasource)
    val mockPhotos = mockPhotoRepository.getPhotos(1)
    println(mockPhotos)
    println("----------------------------------------")

    // todo
    val todoDatasource = FileTodoDatasourceImpl(TODO_PATH)
    val todoPhotoRepository = TodoRepositoryImpl(todoDatasource)
    val todos = todoPhotoRepository.getTodos(1)
    println(todos)
    println("----------------------------------------")
    val mockTodoDatasource = MockTodoDatasourceImpl()
    val mockTodoRepository = TodoRepositoryImpl(mockTodoDatasource)
    val mockTodos = mockTodoRepository.getTodos(1)
    println(mockTodos)
    println("----------------------------------------")
}

class Main() {
    companion object {
        const val COMMON_PATH = "src/main/kotlin/com/luca/kotlinstudy/_15_model_repository/dataSource/"
        const val COMMENT_PATH = COMMON_PATH + "comment/comments.json"
        const val PHOTO_PATH = COMMON_PATH + "photo/photos.json"
        const val TODO_PATH = COMMON_PATH + "todo/todos.json"

    }
}
