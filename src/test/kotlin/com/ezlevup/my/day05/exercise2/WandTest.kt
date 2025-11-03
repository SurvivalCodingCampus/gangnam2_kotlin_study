package com.ezlevup.my.day05.exercise2

import com.ezlevup.my.exercise.Wand
import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class WandTest {
    @Test
    fun `지팡이 이름만 지정해서 인스턴스 초기값 확인`() {
        // given
        val name = "lee"
        val power = Wand.MAX_MAGIC_POWER
        val wand = Wand(name = name, power = power)

        // then
        assertEquals(name, wand.name)
        assertEquals(power, wand.power, 0.01)
    }

    @Test
    fun `지팡이 이름이 빈 문자열이면 예외 1`() {
        // given
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Wand(name = "", power = Wand.MAX_MAGIC_POWER)
        }
        assertTrue(exception.message?.contains("이름은 최소") ?: false)
    }

    @Test
    fun `지팡이 이름이 빈 문자열이면 예외 2`() {
        // given
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "kim", power = Wand.MAX_MAGIC_POWER)
            wand.name = ""
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

    @Test
    fun `지팡이 마력 범위 테스트 정상 범위`() {
        repeat(100) {
            // given
            val randomPower = Random.nextDouble(Wand.MIN_MAGIC_POWER, Wand.MAX_MAGIC_POWER)
            val wand = Wand(name = "kim", power = randomPower)

            // then
            assertTrue(randomPower in Wand.MIN_MAGIC_POWER..Wand.MAX_MAGIC_POWER)
            assertEquals(randomPower, wand.power, 0.01)
        }
    }

    @Test
    fun `지팡이 마력 최소 비정상 범위 예외`() {
        // given
        val power = Wand.MIN_MAGIC_POWER - 0.1
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "kim", power = power)
        }
        assertTrue(exception.message?.contains("지팡이의 마력은") ?: false)
    }

    @Test
    fun `지팡이 마력 최대 비정상 범위 예외 1`() {
        // given
        val power = Wand.MAX_MAGIC_POWER + 0.1
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "kim", power = power)
        }
        assertTrue(exception.message?.contains("지팡이의 마력은") ?: false)
    }

    @Test
    fun `지팡이 마력 최대 비정상 범위 예외 2`() {
        // given
        val power = Wand.MAX_MAGIC_POWER
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val wand = Wand(name = "kim", power = power)
            wand.power += 0.1
        }
        assertTrue(exception.message?.contains("지팡이의 마력은") ?: false)
    }
}