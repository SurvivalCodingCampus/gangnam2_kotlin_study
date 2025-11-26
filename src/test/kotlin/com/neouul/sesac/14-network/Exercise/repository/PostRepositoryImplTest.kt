package com.neouul.sesac.`14-network`.Exercise.repository

import com.neouul.sesac.`14-network`.Exercise.data_source.MockRemoteDataSourceImpl
import com.neouul.sesac.`14-network`.Exercise.data_source.RemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PostRepositoryImplTest {
    private val mockRemoteDataSource: RemoteDataSource = MockRemoteDataSourceImpl()
    private val postRepository: PostRepository = PostRepositoryImpl(mockRemoteDataSource)

    @Test
    fun `getPostByKeyword(keyword) 메서드 성공 케이스 - eum`() = runBlocking {
        val posts = postRepository.getPostsByKeyword("eum")

        assertEquals(5, posts.size)
    }

    @Test
    fun `getPostByKeyword(keyword) 메서드 성공 케이스 - EUM`() = runBlocking {
        val posts = postRepository.getPostsByKeyword("EUM")

        assertEquals(5, posts.size)
    }

    @Test
    fun `getPostByKeyword(keyword) 메서드 성공 케이스 - quia`() = runBlocking {
        val posts = postRepository.getPostsByKeyword("quia")

        assertEquals(12, posts.size)
    }

    @Test
    fun `getPostByKeyword(keyword) 메서드 성공 케이스 - zzz`() = runBlocking {
        val posts = postRepository.getPostsByKeyword("zzz")

        assertEquals(0, posts.size)
    }
}