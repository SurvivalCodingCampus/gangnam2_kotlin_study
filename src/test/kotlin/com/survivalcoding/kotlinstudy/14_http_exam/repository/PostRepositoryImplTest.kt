package com.survivalcoding.kotlinstudy.`14_http_exam`.repository

import Post
import com.survivalcoding.kotlinstudy.`14_http_exam`.data_source.POSTS_ALL
import com.survivalcoding.kotlinstudy.`14_http_exam`.data_source.RemoteDataSource
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class PostRepositoryImplTest {
    val dataSource: RemoteDataSource = MockDataSourceImpl()
    val repository: PostRepository = PostRepositoryImpl(dataSource)

    @Test
    fun getPostsByKeyword() = runTest {
        val results = repository.getPostsByKeyword("sunt")

        assertEquals(results.size, 7)
    }

}

class MockDataSourceImpl : RemoteDataSource {
    override suspend fun getPosts(): List<Post> {
        return Json.decodeFromString(POSTS_ALL)
    }

    override suspend fun getPost(id: Long): Post? {
        TODO("Not yet implemented")
    }

    override suspend fun createPost(post: Post): Post? {
        TODO("Not yet implemented")
    }

    override suspend fun updatePost(id: Long, post: Post): Post? {
        TODO("Not yet implemented")
    }

    override suspend fun patchPost(id: Long, post: Post): Post? {
        TODO("Not yet implemented")
    }

    override suspend fun deletePost(id: Long) {
        TODO("Not yet implemented")
    }

}