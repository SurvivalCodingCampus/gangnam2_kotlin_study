package com.luca.kotlinstudy._16_http.repository

import com.luca.kotlinstudy.core.Response
import com.luca.kotlinstudy._16_http.datasource.RemoteDataSource
import com.luca.kotlinstudy._16_http.model.Post
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PostRepositoryImplTest {

    private lateinit var dataSource: RemoteDataSource
    private lateinit var repository: PostRepositoryImpl

    @Before
    fun setUp() {
        dataSource = mockk()
        repository = PostRepositoryImpl(dataSource)
    }

    @Test
    fun `키워드 포함된 게시글만 반환`() = runBlocking {
        // given
        coEvery { dataSource.getPosts() } returns Response(
            statusCode = 200,
            headers = emptyMap(),
            body = listOf(
                Post(id = 1, "Hello Kotlin", "body", 1),
                Post(2, "Kotlin Study", "body", 1),
                Post(id = 3, "Java Programming", "body", 1)
            )
        )

        // when
        val result = repository.getPostsByKeyword("kotlin")

        // then
        assertEquals(2, result.size)
    }

    @Test
    fun `statusCode가 200이 아니면 빈 리스트`() = runBlocking {
        // given
        coEvery { dataSource.getPosts() } returns Response(
            statusCode = 500,
            headers = emptyMap(),
            body = listOf(
                Post(1, "Hello Kotlin", "body", 1)
            )
        )

        // when
        val result = repository.getPostsByKeyword("kotlin")

        // then
        assertEquals(0, result.size)
    }
}
