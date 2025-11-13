package com.neouul.sesac.`09-file`

import com.neouul.sesac.mock.readInput
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import io.mockk.every
import io.mockk.mockkStatic
import java.io.File

class DefaultFileOperationsTest {

    // JUnit4가 제공하는 테스트 전용 임시 폴더/파일 자동 관리 도구
    // 테스트 메서드 실행 전에 temporary 디렉토리를 생성
    // 테스트 중에 생성한 파일·폴더를 그 내부에 넣음
    // 테스트가 끝나면 자동으로 전체 삭제
    @Rule
    @JvmField
    val tempFolder = TemporaryFolder()

    @Test
    fun `인스턴스가 잘 생성되는 경우`() {
        val defaultFileOperationsTest = DefaultFileOperations()

        assertTrue(defaultFileOperationsTest is FileOperations)
    }

    @Test
    fun `copyFile 메서드 성공`() {
        // given
        val file1 = tempFolder.newFile("a.txt")
        val file2 = tempFolder.newFile("b.txt")
        file1.writeText("Hello World!")

        // when
        DefaultFileOperations().copyFile(file1, file2)

        // then
        assertNotEquals(file1, file2)
        val string1 = file1.readText()
        val string2 = file2.readText()
        assertEquals(string1, string2)
    }

    // 예외를 잘 던지는지 확인하고 싶었는데 try-catch로 처리해서
    // 예외가 밖으로 던져지지 않아서 탐지가 불가능하다
    @Test
    fun `copyFile 메서드 성공 - 원본 파일이 존재하지 않는 경우 예외 처리`() {
        // given
        mockkStatic("com.neouul.sesac.mock.InputKt")
        val newFile = tempFolder.newFile("new.txt")
        every { readInput() } returns newFile.absolutePath

        val file1 = File("a.txt")
        val file2 = tempFolder.newFile("b.txt")
        newFile.writeText("Hello World!")

        // when
        DefaultFileOperations().copyFile(file1, file2)

        // then
        val string1 = newFile.readText()
        val string2 = file2.readText()
        assertEquals(string1, string2)
    }

    @Test
    fun `copyFile 메서드 성공 - 원본 파일과 대상 파일이 같은 경우 예외 처리`() {
        // given
        mockkStatic("com.neouul.sesac.mock.InputKt")
        val newFile = tempFolder.newFile("new.txt")
        every { readInput() } returns newFile.absolutePath

        val file1 = tempFolder.newFile("b.txt")
        val file2 = file1
        file1.writeText("Hello World!")

        // when
        DefaultFileOperations().copyFile(file1, file2)

        // then
        val string1 = file1.readText()
        val string2 = newFile.readText()
        assertEquals(string1, string2)
    }
}