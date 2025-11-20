package com.luca.kotlinstudy._15_model_repository

import com.luca.kotlinstudy._15_model_repository.Main.Companion.commentPath
import com.luca.kotlinstudy._15_model_repository.dataSource.comment.MockCommentDatasourceImpl
import com.luca.kotlinstudy._15_model_repository.repository.CommentRepositoryImpl
import kotlinx.coroutines.runBlocking

/*
[main]
   ↓
[CommentRepository]
   ↓
[CommentRepositoryImpl]
   ↓
[CommentDataSource]
   ↓
[MockCommentDataSourceImpl]
   ↓
[comments.json 읽기]
   ↓
[List<Comment>] 반환
 */
fun main() = runBlocking {
    val dataSource = MockCommentDatasourceImpl(commentPath)
    val repository = CommentRepositoryImpl(dataSource)
    val comments = repository.getComments(1)
    println(comments)
}
class Main(){
    companion object {
        val commentPath = "src/main/kotlin/com/luca/kotlinstudy/_15_model_repository/dataSource/comments.json"
    }
}
