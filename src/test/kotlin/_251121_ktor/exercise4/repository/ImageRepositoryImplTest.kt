package _251121_ktor.exercise4.repository

import _251121_ktor.exercise4.data_source.ImageDataSourceImpl
import _251121_ktor.exercise4.data_source.mockEngine
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ImageRepositoryImplTest {
    //given
    val mockClient = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    val imageDataSourceImpl = ImageDataSourceImpl(mockClient)
    val imageRepositoryImpl = ImageRepositoryImpl(imageDataSourceImpl)

    @Test
    fun `saveImage를 하면 지정한 url의 이미지를 path에 저장해준다`() = runTest {
        //when
        imageRepositoryImpl.saveImage("iu.com", "iu_test.png")
        //then
        assertEquals(File("iu.txt").readText(), File("iu_test.png").readText())
    }

    @Test
    fun `saveImages를 하면 리스트에 들어있는 url의 이미지를 path에 저장해준다`() = runTest {
        //given
        val urlList = listOf("iu.com", "iu.com", "iu.com", "iu.com", "iu.com")
        //when
        imageRepositoryImpl.saveImages(urlList, "iu_tests")
        //then
        for (i in 1..urlList.size) {
            assertEquals(File("iu.txt").readText(), File("iu_tests$i").readText())
        }
    }

    @Test
    fun `saveImageIfNotExists를 하면 파일이 있는 경우 다운로드가 되지 않는다`() = runTest {
        //when
        val result = imageRepositoryImpl.saveImageIfNotExists("iu.com", "iu.txt")
        //then
        assertTrue(result)

    }

    @Test
    fun `saveImageIfNotExists를 하면 파일이 없는 경우 url에서 다운로드를 한다`() = runTest {
        //when
        val result = imageRepositoryImpl.saveImageIfNotExists("iu.com", "iu2.txt")
        //then
        assertFalse(result)
        assertEquals(File("iu.txt").readText(), File("iu2.txt").readText())
    }


    @After
    fun `만들 파일을 모두 삭제한다`() = runTest {
        File("iu_test.png").delete()
        for (i in 1..5) {
            File("iu_tests${i}").delete()
        }
        File("iu2.txt").delete()
    }


}