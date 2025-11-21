package com.ezlevup.my.day251120

import com.ezlevup.my.day251120.data_source.FileCommentDatasourceImpl
import com.ezlevup.my.day251120.data_source.MockCommentDatasourceImpl
import com.ezlevup.my.day251120.repository.CommentRepositoryImpl
import kotlinx.coroutines.runBlocking


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


