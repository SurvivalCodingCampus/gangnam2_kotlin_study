package com.hhp227.kotlinstudy.`10_file`

import kotlin.test.Test
import kotlin.test.assertEquals

class NumberTest {
    @Test
    fun `getNumber메소드로 문자열 숫자가 잘 파싱이 되는지 테스트`() {
        val number = Number()
        val ten = number.getNumber("10")

        assertEquals(10, ten)
    }

    @Test
    fun `getNumber메소드가 문자를 넣을 경우 0으로 처리되는지 테스트`() {
        val number = Number()
        val test = number.getNumber("test")

        assertEquals(0, test)
    }

    @Test
    fun `소수점자리수가 있는 문자열은 0으로 처리되는지 테스트`() {
        val number = Number()
        val four = number.getNumber("4.3")

        assertEquals(0, four)
    }
}