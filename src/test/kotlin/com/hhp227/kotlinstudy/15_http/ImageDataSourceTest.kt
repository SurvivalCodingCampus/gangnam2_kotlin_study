package com.hhp227.kotlinstudy.`15_http`

import com.hhp227.kotlinstudy.`15_http`.image.ImageDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.io.File
import kotlin.test.assertFails
import kotlin.test.assertIs
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageDataSourceTest {
    val imageDataSource = ImageDataSourceImpl()

    @Test
    fun `fetchImage 메소드 테스트`() = runTest {
        val imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2023/07/28/3799c277-b41b-4a79-8d57-6f34f49ee29c.jpg"
        val byteArray = imageDataSource.fetchImage(imageUrl)

        assertTrue(byteArray.isNotEmpty())
        assertIs<ByteArray>(byteArray)
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `saveImage 올바른 이미지가 아니면 에러가 나는지 테스트`() = runTest {
        val imageUrl = "https://chatgpt.com/"
        val byteArray = imageDataSource.fetchImage(imageUrl)
        val filepath = "image1_${Uuid.random().toHexString()}.jpg"

        assertFails { imageDataSource.saveImage(byteArray, filepath) }
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `saveImage 메소드로 이미지 저장하는지 테스트`() = runTest {
        val imageUrl = "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2023/07/28/3799c277-b41b-4a79-8d57-6f34f49ee29c.jpg"
        val byteArray = imageDataSource.fetchImage(imageUrl)
        val filepath = "image1_${Uuid.random().toHexString()}.jpg"
        val file = File(filepath)

        imageDataSource.saveImage(byteArray, filepath)

        assertTrue(file.exists())
        file.delete()
    }
}