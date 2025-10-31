package com.ezlevup.my.day05.exercise2

import org.junit.Assert.*
import org.junit.Test

class WandTest {
    @Test
    fun `지팡이 이름만 지정해서 인스턴스 초기값 확인`() {
        // given
        val name = "lee"
        val power = 100.1
        val wand = Wand(name = name, power = power)

        // then
        assertEquals(name, wand.name)
        assertEquals(power, wand.power, 0.01)
    }

    @Test
    fun `지팡이 이름이 빈 문자열이면 예외`() {
        // given
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Wand(name = "", power = 100.0)
        }
        assertTrue(exception.message?.contains("이름은 최소") ?: false)
    }

    @Test
    fun `지팡이 이름이 너무 짧으면 예외`() {
        // given
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Wand(name = "a", power = 100.0)
        }
        assertTrue(exception.message?.contains("이름은 최소") ?: false)
    }

    @Test
    fun `지팡이 이름이 너무 길면 예외`() {
        // given
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Wand(name = "abcdefghijkl", power = 100.0)
        }
        assertTrue(exception.message?.contains("이름은 최대") ?: false)
    }
}