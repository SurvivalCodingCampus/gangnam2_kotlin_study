package com.ezlevup.my.day251113.exercise


import org.junit.Test
import java.io.File
import kotlin.test.assertNotNull

class DefaultFileOperationsTest {
    @Test
    fun `DefaultFileOperations 생성자`() {
        // given
        val operations = DefaultFileOperations()

        // when & then
        assertNotNull(operations)
    }

    @Test
    fun `DefaultFileOperations 파일 복사 성공`() {
        // given
        val operations = DefaultFileOperations()

        // when
        val sourceFile = File("source.txt")
        val destFile = File("destination.txt")

        // then
        operations.copyFile(sourceFile, destFile)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `DefaultFileOperations 파일 복사 실패`() {
        // given
        val operations = DefaultFileOperations()

        // when
        val sourceFile = File("non-existent.txt")
        val destFile = File("destination.txt")

        // then
        operations.copyFile(sourceFile, destFile)
    }

}