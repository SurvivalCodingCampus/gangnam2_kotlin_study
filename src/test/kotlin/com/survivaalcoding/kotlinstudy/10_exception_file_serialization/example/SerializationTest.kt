package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test
import java.io.File

class SerializationTest {
    @After
    fun tearDown() {
        val company = File(COMPANY_TXT)
        if (company.exists()) {
            company.delete()
        }
    }

    @Test
    fun `직렬화 할 수 있다`() {
        // given
        val company = File(COMPANY_TXT)

        val hong = Employee(name = "홍길동", 41)
        val department = Department("총무부 리더", hong)

        company.writeText(Json.encodeToString(department))

        // when
        val departmentJson = Json.encodeToString(department)

        // then
        assertThat(departmentJson).isEqualTo(company.readText())
    }

    @Test
    fun `역직렬화 할 수 있다`() {
        // given
        val company = File(COMPANY_TXT)

        val hong = Employee(name = "홍길동", 41)
        val department = Department("총무부 리더", hong)

        company.writeText(Json.encodeToString(department))
        val departmentData = company.readText()

        // when
        val departmentDecode = Json.decodeFromString<Department>(departmentData)

        // then
        assertThat(departmentDecode).isEqualTo(department)
    }

    companion object {
        private const val COMPANY_TXT = "company.txt"
    }
}