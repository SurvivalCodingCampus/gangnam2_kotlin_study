package com.survivalcoding.kotlinstudy.`11_file`.practice

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class DepartmentTest {
    @Test
    fun `직렬화가 잘 동작하는지 확인`() {
        val company = File("company.txt")
        val employee = Employee("홍길동", 41)
        val department = Department("총무부", employee)

        company.writeText(department.toJson())

        val actual = company.readText()

        assertTrue(actual.contains(""""name": "총무부""""))
        assertTrue(actual.contains(""""name": "홍길동""""))
        assertTrue(actual.contains(""""age": ${41}"""))

        company.delete()
    }
}