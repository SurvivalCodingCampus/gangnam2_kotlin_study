package com.survival.kotlinstudy.day15.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test

class FileTodoDataSourceImplTest {
    @Test
    fun `FileTodoDataSource - getTodos 테스트`() = runBlocking {
        val filePath = "data/todos.json"
        val datasource = FileTodoDataSourceImpl(filePath)
        val list = datasource.getTodos()

        kotlin.test.assertEquals(200, list.size)
    }

}