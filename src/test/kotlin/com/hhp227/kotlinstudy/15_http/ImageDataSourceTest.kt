package com.hhp227.kotlinstudy.`15_http`

import com.hhp227.kotlinstudy.`15_http`.image.ImageDataSource
import com.hhp227.kotlinstudy.`15_http`.image.ImageDataSourceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import org.junit.Test
import java.io.File
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageDataSourceTest {
    lateinit var imageDataSource: ImageDataSource

    fun createMockClient(
        status: HttpStatusCode,
        responseBody: ByteArray
    ): HttpClient {
        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(responseBody),
                status = status,
                headers = headersOf(HttpHeaders.ContentType, "image/jpeg")
            )
        }
        return HttpClient(mockEngine)
    }

    @Test
    fun `fetchImage 메소드 테스트`() = runTest {
        val mockBytes = byteArrayOf(1, 2, 3, 4)
        val client = createMockClient(HttpStatusCode.OK, mockBytes)
        val imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2023/07/28/3799c277-b41b-4a79-8d57-6f34f49ee29c.jpg"
        imageDataSource = ImageDataSourceImpl(client)
        val byteArray = imageDataSource.fetchImage(imageUrl)

        assertTrue(byteArray.isNotEmpty())
        assertIs<ByteArray>(byteArray)
    }

    @Test
    fun `fetchImage 실패시 예외 발생 테스트`() = runTest {
        val client = createMockClient(HttpStatusCode.NotFound, ByteArray(0))
        imageDataSource = ImageDataSourceImpl(client)

        assertFailsWith<IOException> {
            imageDataSource.fetchImage("http://fakeurl.com/404.jpg")
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `saveImage empty bytes 로 예외 발생 테스트`() = runTest {
        val client = createMockClient(HttpStatusCode.OK, ByteArray(0))
        val filePath = "image1_${Uuid.random().toHexString()}.jpg"
        imageDataSource = ImageDataSourceImpl(client)

        assertFailsWith<IllegalArgumentException> {
            imageDataSource.saveImage(ByteArray(0), filePath)
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `saveImage 메소드로 이미지 저장하는지 테스트`() = runTest {
        val imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2023/07/28/3799c277-b41b-4a79-8d57-6f34f49ee29c.jpg"
        val mockBytes = byteArrayOf(1, 2, 3)
        val client = createMockClient(HttpStatusCode.OK, mockBytes)
        imageDataSource = ImageDataSourceImpl(client)

        val filePath = "image1_${Uuid.random().toHexString()}.jpg"
        val file = File(filePath)

        imageDataSource.saveImage(mockBytes, filePath)

        assertTrue(file.exists())
        assertEquals(mockBytes.size.toLong(), file.length())
        file.delete()
    }
}