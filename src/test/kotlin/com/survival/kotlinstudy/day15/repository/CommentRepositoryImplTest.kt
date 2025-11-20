package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockCommentDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class CommentRepositoryImplTest {

    @Test
    fun `CommentRepositoryImpl 의 getComments 테스트!`(): Unit = runBlocking {
        val expected = 5
        val postId = 1
        val repository = CommentRepositoryImpl(MockCommentDataSourceImpl())
        val list = repository.getComments(postId)

        assertEquals(expected, list.size)
    }
}