package com.survivalcoding.kotlinstudy.`11_file`.practice

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class DefaultFileOperationsTest {
    @Test
    fun `파일의 정보를 잘 가져오는지 확인`() {
        val sourceFile = File("Source.txt")
        val destinationFile = File("Destination.txt")
        val copyTest = DefaultFileOperations()
        val expected = listOf("Kotlin", "Kotlin")

        // 쓰기
        sourceFile.writeText("Kotlin\n")
        sourceFile.appendText("Kotlin\n")
        destinationFile.writeText("")

        // 복사
        copyTest.copyFileSafely(sourceFile, destinationFile)

        val copiedText = destinationFile.readLines()

        assertEquals(copiedText, expected)

        // 삭제
        copyTest.deleteFile(sourceFile, destinationFile)
    }

    @Test
    fun `없는 파일일 경우 예외처리가 되는지 확인`() {
        val sourceFile = File("Source.txt")
        val destinationFile = File("Destination.txt")
        val copyTest = DefaultFileOperations()

        // 복사
        val exceptionTest = copyTest.copyFileSafely(sourceFile, destinationFile)

        assertFalse(exceptionTest)
    }

    @Test
    fun `파일 쓰기 권한이 없을 경우 예외처리 되는지 확인`() {
        val sourceFile = File("Source.txt")
        val destinationFile = File("Destination.txt")
        val copyTest = DefaultFileOperations()

        // 쓰기
        sourceFile.writeText("Kotlin\n")
        destinationFile.writeText("")

        // 읽기 전용
        destinationFile.setReadOnly()

        // 복사
        val exceptionTest = copyTest.copyFileSafely(sourceFile, destinationFile)

        assertFalse(exceptionTest)

        // 삭제
        copyTest.deleteFile(sourceFile, destinationFile)
    }
}