package _251121_ktor.exercise4.data_source

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class ImageDataSourceImplTest {
    val mockClient = HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    val imageDataSourceImpl = ImageDataSourceImpl(mockClient)

    @Test
    fun `fetchImage를 하면 url에 있는 이미지를 이용하여 ByteArray 반환해준다`() = runTest {
        val result = imageDataSourceImpl.fetchImage("iu.com")
        val file = File("iu.txt").readBytes()
        assertTrue(file.contentEquals(result))
    }

    @Test
    fun `saveImage를 하면 해당 path에 사진파일을 저장한다`() = runTest {
        imageDataSourceImpl.saveImage(imageDataSourceImpl.fetchImage("iu.com"), "test_iu.txt")
        assertTrue(File("test_iu.txt").readBytes().contentEquals(File("iu.txt").readBytes()))
    }

    @After
    fun `생성한 test_iu_txt를 제거한다`() {
        File("test_iu.txt").delete()
    }

}