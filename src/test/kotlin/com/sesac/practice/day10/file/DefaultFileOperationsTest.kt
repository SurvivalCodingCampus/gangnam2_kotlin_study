package com.sesac.practice.day10.file

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class DefaultFileOperationsTest {
    private lateinit var operations: DefaultFileOperations
    private lateinit var source: File
    private lateinit var destination: File

    @Before
    fun setUp() {
        operations = DefaultFileOperations()
        source = File(SOURCE_FILE_NAME)
        destination = File(DESTINATION_FILE_NAME)
    }

    @After
    fun tearDown() {
        source.delete()
        destination.delete()
    }

    @Test
    fun `파일을 복사한다`() {
        // given
        source.writeText("test text")

        // when
        operations.copyFile(source, destination)

        // then
        assertEquals(source.readLines(), destination.readLines())
    }

    @Test
    fun `파일을 여러줄을 복사한다`() {
        // given
        source.appendText("test text 1\n")
        source.appendText("test text 2\n")
        source.appendText("test text 3\n")

        // when
        operations.copyFile(source, destination)

        // then
        assertEquals(source.readLines(), destination.readLines())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `존재하지 않는 파일을 복사하면 에러가 발생한다`() {
        // given
        val invalid = File("invalid file")

        // when // then
        operations.copyFile(invalid, destination)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `이미 존재하는 파일로 복사할 경우 에러가 발생한다`() {
        // given
        source.writeText("test text")
        destination.writeText("test text")

        val alreadyExistFile = File(DESTINATION_FILE_NAME)

        // when // then
        operations.copyFile(source, alreadyExistFile)
    }

    companion object {
        const val SOURCE_FILE_NAME = "source.txt"
        const val DESTINATION_FILE_NAME = "destination.txt"
    }
}
