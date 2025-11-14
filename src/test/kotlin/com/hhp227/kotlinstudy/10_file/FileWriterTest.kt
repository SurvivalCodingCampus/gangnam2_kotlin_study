package com.hhp227.kotlinstudy.`10_file`

import kotlinx.serialization.json.Json
import java.io.File
import kotlin.test.*

class FileWriterTest {
    @Test
    fun `파일이 존재하지 않을 경우 파일을 생성하는지 테스트`() {
        val fileWriter = FileWriter()
        val file = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)

        fileWriter.writeFile(department, file)
        assertTrue(file.exists())
        file.delete()
    }

    @Test
    fun `파일이 권한이 없을때 예외를 발생시키는지 테스트`() {
        val fileWriter = FileWriter()
        val file = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)

        file.createNewFile()
        file.setWritable(false)

        assertFails { fileWriter.writeFile(department, file) }
        file.delete()
    }

    @Test
    fun `파일의 저장한 내용이 일치한지 테스트`() {
        val fileWriter = FileWriter()
        val file = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)
        val string = """{"name":"총무부","leader":{"name":"홍길동","age":41}}""".trimIndent()

        file.createNewFile()
        fileWriter.writeFile(department, file)

        val readLines = file.readLines().joinToString("")

        assertEquals(string, readLines)
        file.delete()
    }

    @Test
    fun `파일의 저장한 내용이 다시 객체로 변환되는지 테스트`() {
        val fileWriter = FileWriter()
        val file = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)

        file.createNewFile()
        fileWriter.writeFile(department, file)

        val readLines = file.readLines().joinToString("")

        val imported = Json.decodeFromString<Department>(readLines)
        assertNotNull(imported)
        file.delete()
    }

    @Test
    fun `파일의 저장한 내용이 다시 객체로 변환되고, 내용이 일치하는지 테스트`() {
        val fileWriter = FileWriter()
        val file = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)

        file.createNewFile()
        fileWriter.writeFile(department, file)

        val readLines = file.readLines().joinToString("")

        val imported = Json.decodeFromString<Department>(readLines)
        assertTrue(department == imported)
        file.delete()
    }
}