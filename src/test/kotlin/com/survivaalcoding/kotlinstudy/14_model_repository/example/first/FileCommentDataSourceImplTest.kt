package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.first

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class FileCommentDataSourceImplTest {
    @Test
    fun `json 파일 데이터를 Comment로 역직렬화 할 수 있다`() {
        // given
        val jsonSize = 500

        val file = File("$DIR_PATH$FILE_NAME")
        val mockDataSource = FileCommentDataSourceImpl(file)

        runBlocking {
            // when
            val comments = mockDataSource.getComments()

            // then
            assertEquals(jsonSize, comments.size)
        }
    }

    companion object {
        private const val DIR_PATH =
            "src/main/kotlin/com/survivaalcoding/kotlinstudy/14_model_repository/example/first/"
        private const val FILE_NAME = "comment.json"
    }
}