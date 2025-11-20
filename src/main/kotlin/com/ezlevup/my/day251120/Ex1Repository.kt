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

class MockCommentDatasourceImpl(
    val fileName: String = "comments.json",
) : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        val file = File(fileName)
        val json = file.readText()
        return Json.decodeFromString<List<Comment>>(json).filter { it.postId == postId }
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
    val commentRepository = CommentRepositoryImpl(MockCommentDatasourceImpl())
    val result = commentRepository.getComments(1)
    result.take(1).forEach(::println)
    println(result.count())

}


