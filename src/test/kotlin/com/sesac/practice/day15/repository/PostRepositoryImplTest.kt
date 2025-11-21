package com.sesac.practice.day15.repository

import com.sesac.practice.day15.core.Response
import com.sesac.practice.day15.datasource.RemoteDataSource
import com.sesac.practice.day15.model.Post
import io.mockk.MockKAnnotations
import io.mockk.bdd.coGiven
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PostRepositoryImplTest {

    @MockK
    lateinit var dataSource: RemoteDataSource

    @InjectMockKs
    lateinit var repository: PostRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `keyword 가 포함된 게시글을 가져온다`() = runTest {
        // given
        val keyword = "keyword"

        coGiven { dataSource.getPosts() } returns Response(
            200,
            mapOf(),
            listOf(
                Post(1, 1, "title1", "body"),
                Post(1, 2, "title2", "body"),
                Post(1, 3, "keyword title", "body"),
                Post(1, 4, "title keyword title", "body"),
                Post(1, 5, "title keyword", "body"),
            ),
        )

        // when
        val posts = repository.getPostsByKeyword(keyword)

        // then
        assertEquals(3, posts.size)
    }
}
