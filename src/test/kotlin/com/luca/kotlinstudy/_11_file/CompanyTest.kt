package com.luca.kotlinstudy._11_file

import org.junit.Assert.*
import java.io.File
import kotlin.test.Test

class CompanyTest {

    @Test
    fun `부서 JSON 파일 생성되는지 테스트`() {
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)
        val company = Company(department)


        company.saveToFile()
        val file = File("company.txt")
        val text = file.readText()

        assertEquals(employee, department.leader)
        assertEquals(department, company.department)
        assertTrue(file.exists())
        assertEquals("company.txt", file.name)
        assertTrue(text.contains("홍길동"))
        assertTrue(text.contains("총무부"))
        file.delete()
    }
}