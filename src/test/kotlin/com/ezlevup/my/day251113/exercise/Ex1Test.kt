package com.ezlevup.my.day251113.exercise

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class Ex1Test {
    @Test
    fun `Sting toIntOrZero 성공`() {
        // given
        val numString: String = "10"
        val numInt: Int = 10

        // when
        val num = numString.toIntOrZero()

        // then
        assertNotEquals(0, num)
        assertEquals(numInt, num)
    }

    @Test
    fun `Sting toIntOrZero 실패`() {
        // given
        val numString: String = "10.9"

        // when
        val num = numString.toIntOrZero()

        // then
        assertEquals(0, num)
    }
}
