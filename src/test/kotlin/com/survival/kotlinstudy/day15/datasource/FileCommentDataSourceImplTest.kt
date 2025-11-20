package com.survival.kotlinstudy.day15.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test

class FileCommentDataSourceImplTest {
    @Test
    fun `FileCommentDataSource - getComments 테스트`() = runBlocking {
        val filePath = "data/comments.json"
        val datasource = FileCommentDataSourceImpl(filePath)
        val list = datasource.getComments()

        kotlin.test.assertEquals(500, list.size)
    }
}