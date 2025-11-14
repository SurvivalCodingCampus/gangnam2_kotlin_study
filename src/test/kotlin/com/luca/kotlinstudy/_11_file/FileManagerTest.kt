package com.luca.kotlinstudy._11_file

import org.junit.Assert.*
import java.io.File
import kotlin.test.Test

class FileManagerTest {

    @Test
    fun `파일 복사 테스트`() {
        val manager = FileManager()

        val src = File("save.txt")
        val dest = File("copy.txt")

        src.writeText("Hello World")
        manager.copyFile(src, dest)

        assertTrue(dest.exists())
        assertEquals("Hello World", dest.readText())

        // 정리
        src.delete()
        dest.delete()
    }

}