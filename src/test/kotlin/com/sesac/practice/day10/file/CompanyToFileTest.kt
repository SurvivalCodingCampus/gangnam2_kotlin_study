package com.sesac.practice.day10.file

import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class CompanyToFileTest {
    @Test
    fun `인스턴스를 직렬화 후 파일을 저장한다`() {
        // given
        val department = Department("총무부", Employee("홍길동", 41))

        // when
        CompanyToFile.toFile(department)

        // then
        val file = File(CompanyToFile.FILE_NAME)
        val json = file.readText()
        file.delete()

        val actual = Json.decodeFromString<Department>(json)
        assertEquals(department, actual)
    }
}
