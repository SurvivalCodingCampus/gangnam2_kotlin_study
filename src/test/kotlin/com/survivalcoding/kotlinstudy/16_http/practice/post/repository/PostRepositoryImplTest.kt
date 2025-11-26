package com.survivalcoding.kotlinstudy.`16_http`.practice.post.repository

import com.survivalcoding.kotlinstudy.`16_http`.practice.model.Post
import com.survivalcoding.kotlinstudy.`16_http`.practice.repository.PostRepositoryImpl
import com.survivalcoding.kotlinstudy.`18_result`.practice.util.Response
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class PostRepositoryImplTest {

    private val dataSource = MockRemoteDataSourceImpl()
    private val repository = PostRepositoryImpl(dataSource)

    @Test
    fun `입력한 keyword의 title을 가진 게시글만 잘 가져오는지 확인`() = runBlocking {
        val testKeyword = "es"
        val response: Response<List<Post>> = repository.getPostByKeyword(testKeyword)
        val posts: List<Post> = response.body

        assertTrue(posts.all { it.title?.contains(testKeyword) == true })
    }
}