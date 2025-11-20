package com.ezlevup.my.day251120

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
)

interface CommentDataSource {
    suspend fun getComments(postId: Int): List<Comment>
}

class FileCommentDatasourceImpl(
    val fileName: String = "comments.json",
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Comment>>(json).filter { it.postId == postId }
    }
}

class MockCommentDatasourceImpl(
    val fileName: String = "no-file.json",
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        return listOf(
            Comment(postId = 1, id = 1, name = "lee1", email = "lee1@naver.com", body = "f1"),
            Comment(postId = 1, id = 2, name = "lee1", email = "lee2@naver.com", body = "f2"),
        )
    }
}

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}

class CommentRepositoryImpl(
    val commentDataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return commentDataSource.getComments(postId)
    }
}

fun main(): Unit = runBlocking {
    val commentRepository = CommentRepositoryImpl(FileCommentDatasourceImpl())
    val result = commentRepository.getComments(1)
    result.take(1).forEach(::println)
    println(result.count())

    CommentRepositoryImpl(MockCommentDatasourceImpl())
        .getComments(1)
        .take(1)
        .forEach(::println)
}


