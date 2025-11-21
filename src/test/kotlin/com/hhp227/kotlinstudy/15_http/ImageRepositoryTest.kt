package com.hhp227.kotlinstudy.`15_http`

import com.hhp227.kotlinstudy.`15_http`.image.ImageDataSourceImpl
import com.hhp227.kotlinstudy.`15_http`.image.ImageRepositoryImpl
import kotlinx.coroutines.test.runTest
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageRepositoryTest {
    val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `saveImage 메소드로 이미지 저장하는지 테스트`() = runTest {
        val path = "image1_${Uuid.random().toHexString()}.jpg"
        val imageUrl = "https://i.namu.wiki/i/rPpdSo1zioMi6PVX7vflwnqejXQEweT3zoc0mQleUXkpmrSfHRyX_B7Pht0z0T_80it32D97ZYIJZ8mTRgiJ0Q.webp"
        val file = File(path)

        imageRepository.saveImage(imageUrl, path)
        assertTrue(file.exists())
        imageRepository.clearCache()
        file.delete()
    }

    @Test
    fun `saveImages 메소드로 여러장의 이미지를 지정된 경로로 저장하는지 테스트`() = runTest {
        val directoryPath = "ive"
        val imageUrlList = listOf(
            "https://cdn.hankooki.com/news/photo/202412/212132_294589_1733037937.jpg",
            "https://cdn.m-i.kr/news/photo/202404/1116075_883273_204.jpg",
            "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2022/01/16/OhTC8EqAhoCg637779288570528338.jpg",
            "https://img0.yna.co.kr/photo/yna/YH/2023/04/10/PYH2023041016590001300_P4.jpg",
            "https://cdn.sports.hankooki.com/news/photo/202404/6861767_1079580_1631.jpg"
        )
        imageRepository.saveImages(imageUrlList, directoryPath)
        File(directoryPath).also { file ->
            val files = file.listFiles()

            assertEquals(files.size, imageUrlList.size)
            imageRepository.clearCache()
            file.deleteRecursively()
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `파일이 존재하면 파일 저장, 아니면 다운로드하는지 테스트`() = runTest {
        val directoryPath = "ive"
        val imageUrlListBefore = listOf(
            "https://cdn.m-i.kr/news/photo/202404/1116075_883273_204.jpg",
            "https://cdn.sports.hankooki.com/news/photo/202404/6861767_1079580_1631.jpg"
        )
        val imageUrlListAfter = listOf(
            "https://cdn.hankooki.com/news/photo/202412/212132_294589_1733037937.jpg",
            "https://cdn.m-i.kr/news/photo/202404/1116075_883273_204.jpg",
            "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2022/01/16/OhTC8EqAhoCg637779288570528338.jpg",
            "https://img0.yna.co.kr/photo/yna/YH/2023/04/10/PYH2023041016590001300_P4.jpg",
            "https://cdn.sports.hankooki.com/news/photo/202404/6861767_1079580_1631.jpg"
        )
        val file = File(directoryPath)

        imageRepository.saveImages(imageUrlListBefore, directoryPath)
        for (i in imageUrlListAfter.indices) {
            val url = imageUrlListAfter[i]
            val filename = "$directoryPath\\image${i}_${Uuid.random().toHexString()}.jpg"
            val isSaveImageSuccess = imageRepository.saveImageIfNotExists(url, filename)

            if (url !in imageUrlListBefore) {
                assertTrue(isSaveImageSuccess)
            } else {
                assertFalse(isSaveImageSuccess)
            }
        }
        file.deleteRecursively()
        imageRepository.clearCache()
    }
}