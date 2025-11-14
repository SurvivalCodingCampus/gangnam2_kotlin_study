package com.sesac.practice.day10.exception

import org.junit.Assert.assertEquals
import org.junit.Test

class StringToIntTest {
    @Test
    fun `문자를 숫자로 변환한다`() {
        // given
        val num = 10
        val numString = num.toString()

        // when
        val actual = StringToInt.parse(numString)

        // then
        assertEquals(num, actual)
    }

    @Test
    fun `잘못된 형식의 문자를 변환할 경우 0으로 반환한다`() {
        // given
        val numString = "10.5"

        // when
        val actual = StringToInt.parse(numString)

        // then
        assertEquals(0, actual)
    }
}
