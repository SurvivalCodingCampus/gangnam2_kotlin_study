package _251121_ktor.exercise1to3.repository

import _251121_ktor.exercise1to3.data_source.RemoteDataSourceImpl
import _251121_ktor.exercise1to3.data_source.mockEngine
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class PostRepositoryImplTest {
    //given
    val mockClient = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    val mockRemoteDataSourceImpl = RemoteDataSourceImpl(mockClient)
    val postRepositoryImpl = PostRepositoryImpl(mockRemoteDataSourceImpl)

    @Test
    fun `getPostsByKeyword함수에서 title에 hi가 포함된 게시글은 5개이다`() = runTest {
        //when
        val result = postRepositoryImpl.getPostsByKeyword("hi")
        //then
        assertEquals(5, result.size)
    }

    @Test
    fun `getPostsByKeyword함수에서 title에 안녕이 포함된 게시글은 0개이다`() = runTest {
        //when
        val result = postRepositoryImpl.getPostsByKeyword("안녕")
        //then
        assertEquals(0, result.size)
    }

}