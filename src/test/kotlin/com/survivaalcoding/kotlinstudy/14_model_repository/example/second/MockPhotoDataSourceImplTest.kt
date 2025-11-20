package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.second

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class MockPhotoDataSourceImplTest {
    @Test
    fun `json 파일 데이터를 Photo로 역직렬화 할 수 있다`() {
        // given
        val jsonSize = 5000

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = MockPhotoDataSourceImpl(file)

        runBlocking {
            // when
            val photos = mockDataSource.getPhoto()

            // then
            assertEquals(jsonSize, photos.size)
        }
    }

    companion object {
        private const val DIR_PATH = "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/second/"
        private const val FILE_NAME = "photos.json"
    }
}