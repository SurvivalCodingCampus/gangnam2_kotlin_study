package com.hhp227.kotlinstudy.`10_file`

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

class DefaultFileOperationsTest {
    @Test
    fun `파일이 지정된 경로를 찾을 수 있는지 테스트`() {
        val file = File("")

        assertFails { file.createNewFile() }
    }

    @Test
    fun `파일이 존재하지 않을 경우 예외를 던지는지 테스트`() {
        val fileOperations = DefaultFileOperations()
        val file = File("sample.txt")
        val targetFile = File("target.txt")

        assertFails { fileOperations.copyFile(file, targetFile) }
    }

    @Test
    fun `destination이 파일이 없을 경우 파일을 생성해주는지 테스트`() {
        val fileOperations = DefaultFileOperations()
        val file = File("sample.txt")
        val targetFile = File("target.txt")

        file.createNewFile()

        fileOperations.copyFile(file, targetFile)
        assertTrue(targetFile.exists())
        file.delete()
        targetFile.delete()
    }

    @Test
    fun `target파일이 권한이 없을때 예외를 발생시키는지 테스트`() {
        val fileOperations = DefaultFileOperations()
        val file = File("sample.txt")
        val targetFile = File("target.txt")

        file.createNewFile()
        targetFile.createNewFile()
        targetFile.setWritable(false)

        assertFails { fileOperations.copyFile(file, targetFile) }
        targetFile.delete()
    }

    @Test
    fun `파일복사 한 내용이 일치한지 테스트`() {
        val fileOperations = DefaultFileOperations()
        val file = File("sample.txt")
        val targetFile = File("target.txt")
        val text = "Hello world!!!!"

        file.createNewFile()
        targetFile.createNewFile()

        file.writeText(text)

        fileOperations.copyFile(file, targetFile)
        assertEquals(text, targetFile.readLines().first())
        file.delete()
        targetFile.delete()
    }

    @Test
    fun `복사한 파일 여러줄의 내용이 일치한지 테스트`() {
        val fileOperations = DefaultFileOperations()
        val file = File("sample.txt")
        val targetFile = File("target.txt")
        val text =
            """
            Hello world!!!!
            I'm fine thanks and you?
            have a nice day
            """.trimMargin()

        file.createNewFile()
        targetFile.createNewFile()

        file.writeText(text)

        fileOperations.copyFile(file, targetFile)

        val copiedText = targetFile.readLines().joinToString("\n")

        assertEquals(text, copiedText)
        file.delete()
        targetFile.delete()
    }
}