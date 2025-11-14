package com.survivalcoding.kotlinstudy.`11_exception_file_data`

import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EmployeeTest {

    companion object {
        private const val FILE_NAME = "employee.txt"
        private const val NAME = "홍길동"
        private const val AGE = 41
        private const val DEPT_NAME = "총무부"
    }

    @Before
    fun setUp() {
        // 테스트 시작 전 파일 제거
        File(FILE_NAME).delete()
    }

    @Test
    fun `파일 저장 성공 - 직렬화 정상`() {
        // given
        val dept = Department(DEPT_NAME, Employee(NAME, AGE))

        // when
        val result = jsonEncodeToString(dept)

        // then
        assertTrue(File(FILE_NAME).exists())

        val saved = File(FILE_NAME).readText()   // 파일 내용을 읽기
        val expected = Json.encodeToString(dept) // 기대되는 JSON 문자열

        assertEquals(expected, saved)            // 파일 내용 비교
    }

    @After
    fun tearDown() {
        // 테스트 종료 후 파일 정리
        File(FILE_NAME).delete()
    }
}
