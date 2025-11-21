package com.survival.kotlinstudy.day16.repository

import com.survival.kotlinstudy.day16.datasource.MockDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PostRepositoryImplTest {
    @Test
    fun `getPostsByKeyword 테스트`() = runBlocking {
        val repository = PostRepositoryImpl(MockDataSourceImpl())
        val keyword = "Test"
        val expected = 2
        val response = repository.getPostsByKeyword(keyword)

        kotlin.test.assertEquals(response?.size,expected)
    }
}