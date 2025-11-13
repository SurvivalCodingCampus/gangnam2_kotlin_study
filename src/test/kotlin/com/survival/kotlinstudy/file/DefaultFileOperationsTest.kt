package com.survival.kotlinstudy.file

import org.junit.Assert.*
import org.junit.Test
import java.io.File
import kotlin.test.assertFalse

class DefaultFileOperationsTest {


    @Test
    fun `source 파일을 destination으로 복사하기 테스트`() {
        // given (준비)
        val sourceName = "source.txt"
        val destinationName = "destination.txt"

        val sourceFile = File(sourceName)
        val destinationFile = File(destinationName)
        val text = "Hello Hello"
        sourceFile.writeText(text)

        val fileOperations = DefaultFileOperations()

        // when (실행)

        fileOperations.copyFile(sourceFile, destinationFile)

        // then (검증)
        assertEquals(text, destinationFile.readText())

        sourceFile.delete()
        destinationFile.delete()
    }

    @Test
    fun `원본 파일이 존재하지 않을 경우 테스트`() {
        // given (준비)
        val fileOperator = DefaultFileOperations()

        val nonExistentSource = File("start.txt")
        val destination = File("destination.txt")

        // then (검증)
        fileOperator.copyFile(nonExistentSource,destination)

        assertFalse(destination.exists(), "대상 파일이 생성되지 않았어야 합니다.")
    }

}