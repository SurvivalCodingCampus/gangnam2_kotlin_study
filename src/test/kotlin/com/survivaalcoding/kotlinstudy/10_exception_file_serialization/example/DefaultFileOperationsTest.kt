package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.After
import org.junit.Test
import java.io.File

class DefaultFileOperationsTest {
    @After
    fun tearDown() {
        val unAccessFile = File(UN_ACCESS_FILE)
        if (unAccessFile.exists()) {
            unAccessFile.delete()
        }

        val sourceFile = File(SOURCE_FILE)
        if (sourceFile.exists()) {
            sourceFile.delete()
        }

        val destinationFile = File(DESTINATION_FILE)
        if (destinationFile.exists()) {
            destinationFile.delete()
        }
    }

    @Test
    fun `원본 파일이 존재하지 않으면 예외가 발생한다`() {
        // given
        val source = File("nonExists.txt")
        val destination = File(DESTINATION_FILE)

        val defaultFileOperations = DefaultFileOperations()

        // when
        // then
        assertThatThrownBy { defaultFileOperations.copyFile(source, destination) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `원본 파일에 접근할 권한이 없으면 예외가 발생한다`() {
        // given
        val source = File(UN_ACCESS_FILE)
        val destination = File(DESTINATION_FILE)

        val defaultFileOperations = DefaultFileOperations()

        source.setReadable(false)

        // when
        // then
        assertThatThrownBy { defaultFileOperations.copyFile(source, destination) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun `원본 파일의 내용을 다른 파일에 복사한다`() {
        // given
        val source = File(SOURCE_FILE)
        source.appendText("Hello world\n")
        source.appendText("Hello world\n")

        val destination = File(DESTINATION_FILE)

        val defaultFileOperations = DefaultFileOperations()

        // when
        defaultFileOperations.copyFile(source, destination)

        // then
        val sourceReadLine = source.readLines()
        val destinationReadLine = destination.readLines()

        assertThat(sourceReadLine.size).isEqualTo(destinationReadLine.size)
        assertThat(sourceReadLine).isEqualTo(destinationReadLine)
    }

    @Test
    fun `복사 대상 파일에 쓰기 권한이 없으면 예외가 발생한다`() {
        // given
        val source = File(SOURCE_FILE)
        val destination = File(DESTINATION_FILE)

        val defaultFileOperations = DefaultFileOperations()

        destination.setWritable(false)

        // when
        // then
        assertThatThrownBy { defaultFileOperations.copyFile(source, destination) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    companion object {
        private const val UN_ACCESS_FILE = "unaccess.txt"
        private const val SOURCE_FILE = "source.txt"
        private const val DESTINATION_FILE = "destination.txt"
    }
}