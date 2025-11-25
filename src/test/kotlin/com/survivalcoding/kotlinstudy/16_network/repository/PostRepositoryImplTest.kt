package com.survivalcoding.kotlinstudy.`16_network`.repository

import com.survivalcoding.kotlinstudy.`16_network`.core.Response
import com.survivalcoding.kotlinstudy.`16_network`.data_source.RemoteDataSource
import com.survivalcoding.kotlinstudy.`16_network`.model.Post
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PostRepositoryImplTest {

    companion object {

        // Status Code
        private const val STATUS_OK = 200

        // ID
        private const val USER_ID = 1
        private const val ID1 = 1
        private const val ID2 = 2
        private const val ID3 = 3

        // Title
        private const val TITLE_HELLO = "Hello World"
        private const val TITLE_KOTLIN = "Kotlin Study"
        private const val TITLE_OTHER = "Other Title"

        // Body
        private const val BODY1 = "body1"
        private const val BODY2 = "body2"
        private const val BODY3 = "body3"


        // Keyword
        private const val KEYWORD_KOTLIN = "Kotlin"
        private const val KEYWORD_NOT_FOUND = "not found"
        private const val KEYWORD_ANY = "hello"


        // Result
        private const val RESULT_SIZE_KOTLIN = 1
        private const val RESULT_EMPTY = 0
    }

    // Mock Data
    private val posts = listOf(
        Post(USER_ID, ID1, TITLE_HELLO, BODY1),
        Post(USER_ID, ID2, TITLE_KOTLIN, BODY2),
        Post(USER_ID, ID3, TITLE_OTHER, BODY3)
    )

    private val mockDataSource = mockk<RemoteDataSource>()
    private val repository = PostRepositoryImpl(mockDataSource)

    @Test
    fun `keyword 필터링 성공`() = runBlocking {
        // given
        coEvery { mockDataSource.getPosts() } returns Response(
            statusCode = STATUS_OK,
            headers = emptyMap(),
            body = posts
        )

        // when
        val result = repository.getPostByKeyword(KEYWORD_KOTLIN)

        // then
        assertEquals(RESULT_SIZE_KOTLIN, result!!.size)
        assertEquals(TITLE_KOTLIN, result[0].title)
    }

    @Test
    fun `keyword 필터링 성공 - 빈 리스트 반환`() = runBlocking {
        // given
        coEvery { mockDataSource.getPosts() } returns Response(
            statusCode = STATUS_OK,
            headers = emptyMap(),
            body = posts
        )

        // when
        val result = repository.getPostByKeyword(KEYWORD_NOT_FOUND)

        // then
        assertEquals(RESULT_EMPTY, result!!.size)
    }

    @Test
    fun `body null - null 반환`() = runBlocking {
        // given
        coEvery { mockDataSource.getPosts() } returns Response(
            statusCode = STATUS_OK,
            headers = emptyMap(),
            body = null
        )

        // when
        val result = repository.getPostByKeyword(KEYWORD_ANY)

        // then
        assertNull(result)
    }
}
