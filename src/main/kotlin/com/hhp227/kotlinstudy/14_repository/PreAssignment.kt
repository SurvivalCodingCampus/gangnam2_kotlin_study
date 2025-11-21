package com.hhp227.kotlinstudy.`14_repository`

import com.hhp227.kotlinstudy.`13_datasource`.FileLoadUtil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
과제1. Repository 작성 연습 1
https://jsonplaceholder.typicode.com/comments
의 정보를 데이터소스로 하는 CommentRepository 를 작성하시오.
MockCommentDatasourceImpl
CommentRepositoryImpl

작성할 메소드
suspend fun getComments(postId: Int): List<Comment>

과제2. Repository 작성 연습 2
https://jsonplaceholder.typicode.com/photos
의 정보를 데이터소스로 하는 PhotoRepository 를 작성하시오.

작성할 메소드
suspend fun getPhotos(albumId: Int) : List<Photo>

과제3. Repository 작성 연습 3
https://jsonplaceholder.typicode.com/todos
의 정보를 데이터소스로 하는 TodoRepository 를 작성하시오.

작성할 메소드
suspend fun getTodos(): List<Todo>
suspend fun getCompletedTodos() : List<Todo>

과제4. Repository 작성 연습 4
https://jsonplaceholder.typicode.com/users
의 정보를 데이터 소스로 하는 UserRepository 를 작성하시오.

작성할 메소드
suspend fun getUsers() : List<User>
suspend fun getUsersTop10ByUserName() : List<User>

과제5. Repository 작성 연습 5
https://jsonplaceholder.typicode.com/albums
의 정보를 데이터소스로 하는 AlbumRepository 를 작성하시오.

작성할 메소드
suspend fun getAlbums(limit: Int? = null): List<Album>
limit 을 지정하지 않으면 모든 데이터를
limit 을 지정하면 limit 갯수만큼

 */

@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

interface CommentDataSource {
    suspend fun getAllComments(): List<Comment>
}

class MockCommentDataSourceImpl(private val filename: String) : CommentDataSource {
    override suspend fun getAllComments(): List<Comment> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}

class CommentRepositoryImpl(private val commentDataSource: CommentDataSource) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return commentDataSource.getAllComments().filter { it.postId == postId }
    }
}

// -------------------------------------------

@Serializable
data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

interface PhotoDataSource {
    suspend fun getAllPhotos(): List<Photo>
}

class MockPhotoDataSourceImpl(private val filename: String) : PhotoDataSource {
    override suspend fun getAllPhotos(): List<Photo> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int) : List<Photo>
}

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return photoDataSource.getAllPhotos().filter { it.albumId == albumId }
    }
}

// -------------------------------------------

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerialName("completed")
    val isCompleted: Boolean
)

interface TodoDataSource {
    suspend fun getAllTodos(): List<Todo>
}

class MockTodoDataSourceImpl(private val filename: String) : TodoDataSource {
    override suspend fun getAllTodos(): List<Todo> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}

interface TodoRepository {
    suspend fun getTodos(): List<Todo>

    suspend fun getCompletedTodos(): List<Todo>
}

class TodoRepositoryImpl(private val todoDataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getAllTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return getTodos().filter(Todo::isCompleted)
    }
}

// -------------------------------------------

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

@Serializable
data class Address(val street: String, val suite: String, val city: String, val zipcode: String, val geo: Geo)

@Serializable
data class Geo(val lat: String, val lng: String)

@Serializable
data class Company(val name: String, val catchPhrase: String, val bs: String)

interface UserDataSource {
    suspend fun getAllUsers(): List<User>
}

class MockUserDataSourceImpl(private val filename: String) : UserDataSource {
    override suspend fun getAllUsers(): List<User> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}

interface UserRepository {
    suspend fun getUsers(): List<User>

    suspend fun getUsersTop10ByUserName(): List<User>
}

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userDataSource.getAllUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers().sortedBy { it.username }.take(10)
    }
}

// -------------------------------------------

@Serializable
data class Album(val userId: Int, val id: Int, val title: String)

interface AlbumDataSource {
    suspend fun getAllAlbum(): List<Album>
}

class MockAlbumDataSourceImpl(private val filename: String) : AlbumDataSource {
    override suspend fun getAllAlbum(): List<Album> {
        val jsonString = FileLoadUtil.loadFileToString(filename)
        return Json.decodeFromString(jsonString)
    }
}

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}

class AlbumRepositoryImpl(private val albumDataSource: AlbumDataSource) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albumList = albumDataSource.getAllAlbum()
        return limit?.let(albumList::take) ?: albumList
    }
}