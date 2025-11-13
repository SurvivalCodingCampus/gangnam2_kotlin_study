package com.survivalcoding.kotlinstudy.`11_exception_file_data`

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class DefaultFileOperationsTest {

    companion object {
        private const val SOURCE = "./save.txt"
        private const val DESTINATION = "./save_copy.txt"
        private const val NO_EXIST_SOURCE = "./no_exist.txt"
        private const val FILE_TEXT = "Hello wolrd!!!!"
        private const val EMPTY_FILE_TEXT = ""
    }

    // 테스트 시작 전 정리
    @Before
    fun setUp() {
        File(SOURCE).delete()
        File(DESTINATION).delete()
    }

    @Test
    fun `정상 복사 테스트`() {
        // givn
        val source = File(SOURCE).apply { writeText(FILE_TEXT) }
        val destination = File(DESTINATION)

        // when
        DefaultFileOperations().copyFile(source, destination)

        val original = source.readText()
        val copied = destination.readText()

        // then
        assertEquals(original, copied)
    }


    @Test
    fun `복사 실패 - 원본 파일 없음`() {
        // givn
        val source = File(NO_EXIST_SOURCE)
        val destination = File(DESTINATION)
        destination.delete() // 혹시 있을까봐 삭제

        // when
        DefaultFileOperations().copyFile(source, destination)

        // then
        assert(!destination.exists())
    }

    @Test
    fun `원본 파일이 빈 파일일 때`() {
        // given
        val source = File(SOURCE).apply { writeText(EMPTY_FILE_TEXT) }
        val destination = File(DESTINATION)

        // when
        DefaultFileOperations().copyFile(source, destination)

        // then
        assertEquals("", destination.readText())
    }

    @Test
    fun `내용 덮어쓰기`() {
        // given
        val source = File(SOURCE).apply { writeText("original") }
        val destination = File(DESTINATION).apply { writeText("old") }

        // when
        DefaultFileOperations().copyFile(source, destination)

        // then
        assertEquals("original", destination.readText())
    }

    // 테스트 끝난 뒤 정리
    @After
    fun fileDelete() {
        File(SOURCE).delete()
        File(DESTINATION).delete()
    }
}
