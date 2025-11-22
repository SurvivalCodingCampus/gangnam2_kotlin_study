package com.sesac.practice.day15.repository

import com.sesac.practice.day15.core.FileProvider
import com.sesac.practice.day15.datasource.ImageDataSource
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.bdd.coGiven
import io.mockk.bdd.coThen
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.just
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ImageRepositoryImplTest {

    @MockK
    lateinit var dataSource: ImageDataSource

    @MockK
    lateinit var fileProvider: FileProvider

    @InjectMockKs
    lateinit var repository: ImageRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `URL 에서 이미지를 다운로드하여 지정된 경로에 저장한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = "/images/test.png"
        val bytes = byteArrayOf(1, 2, 3)

        coGiven { dataSource.fetchImage(url) } returns bytes
        coGiven { dataSource.saveImage(bytes, path) } just Runs

        // when
        repository.saveImage(url, path)

        // then
        coThen { dataSource.fetchImage(url) }
        coThen { dataSource.saveImage(bytes, path) }
    }

    @Test
    fun `여러 URL 의 이미지들을 지정된 디렉토리에 저장한다`() = runTest {
        // given
        val urls = listOf(
            "https://test.com/image.png",
            "https://test.com/image2.png",
        )
        val directory = "/images"
        val bytes = byteArrayOf(1, 2, 3)

        coGiven { dataSource.fetchImage(any()) } returns bytes
        coGiven { dataSource.saveImage(any(), any()) } just Runs

        // when
        repository.saveImages(urls, directory)

        // then
        coThen(exactly = 2) { dataSource.fetchImage(any()) }
        coThen { dataSource.saveImage(bytes, "/images/image(1).png") }
        coThen { dataSource.saveImage(bytes, "/images/image(2).png") }
    }

    @Test
    fun `이미지가 존재하지 않는 경우 URL 에서 다운로드하여 저장하고 true 를 반환한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = "/images/test.png"
        val bytes = byteArrayOf(1, 2, 3)

        coGiven { dataSource.fetchImage(url) } returns bytes
        coGiven { dataSource.saveImage(bytes, path) } just Runs
        coGiven { fileProvider.exists(path) } returns false

        // when
        val isSaved = repository.saveImageIfNotExist(url, path)

        // then
        assertTrue(isSaved)

        coThen { dataSource.fetchImage(url) }
        coThen { dataSource.saveImage(bytes, path) }
    }

    @Test
    fun `이미지가 존재하는 경우 다운로드 하지 않고 false 를 반환한다`() = runTest {
        // given
        val url = "https://test.com/image.png"
        val path = "/images/test.png"
        val bytes = byteArrayOf(1, 2, 3)

        coGiven { dataSource.fetchImage(url) } returns bytes
        coGiven { dataSource.saveImage(bytes, path) } just Runs
        coGiven { fileProvider.exists(path) } returns true

        // when
        val isSaved = repository.saveImageIfNotExist(url, path)

        // then
        assertFalse(isSaved)

        coThen(exactly = 0) { dataSource.fetchImage(url) }
        coThen(exactly = 0) { dataSource.saveImage(any(), path) }
    }
}
