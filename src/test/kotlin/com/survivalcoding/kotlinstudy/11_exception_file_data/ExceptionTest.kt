package com.survivalcoding.kotlinstudy.`11_exception_file_data`

import kotlin.test.Test
import kotlin.test.assertEquals

class ExceptionTest {
    companion object {
        private const val INT_TEXT = "123"
        private const val TEXT_TO_INT = 123
        private const val STRING_TEXT = "hello"
        private const val DOUBLE_TEXT = "10.5"
        private const val EMPTY_TEXT = ""
        private const val WHITE_SPACE_TEXT = " "

    }

    @Test
    fun `정상 변환`() {
        //given
        val original = INT_TEXT

        // when
        val result = StringToInt(original)

        // then
        assertEquals(TEXT_TO_INT, result)
    }

    @Test
    fun `변환 오류 - 숫자가 아닌 문자열`() {
        // given
        val original = STRING_TEXT

        // when
        val result = StringToInt(original)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `변환 오류 - 소수 문자열`() {
        // given
        val original = DOUBLE_TEXT

        // when
        val result = StringToInt(original)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `변환 오류 - 빈 문자열`() {
        // given
        val original = EMPTY_TEXT

        // when
        val result = StringToInt(original)

        // then
        assertEquals(0, result)
    }

    @Test
    fun `변환 오류 - 공백 문자열`() {
        // given
        val original = WHITE_SPACE_TEXT

        // when
        val result = StringToInt(original)

        // then
        assertEquals(0, result)
    }
}