package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException

class FileUtilsTest {
    @Test
    fun `File의 내용을 가져올 수 있다`() {
        // given
        val path = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example/todo.json"
        val jsonData = """
            {
              "userId": 1,
              "id": 1,
              "title": "delectus aut autem",
              "completed": false
            }
            """.trimIndent()

        // when
        val fileText = FileUtils.getFileText(path)

        // then
        assertEquals(jsonData.replace("\r\n", "\n"), fileText.replace("\r\n", "\n"))
    }

    @Test
    fun `파일이 존재하지 않으면 예외가 발생한다`() {
        // given
        val path = "dummy.json"

        // when
        // then
        assertThrows<FileNotFoundException> {
            FileUtils.getFileText(path)
        }
    }

    @Test
    fun `디렉토리를 읽으면 예외가 발생한다`() {
        // given
        val path = "src/main/kotlin/com/survivaalcoding/kotlinstudy/13_datasource/example"

        // when
        // then
        assertThrows<IllegalStateException> {
            FileUtils.getFileText(path)
        }
    }
}