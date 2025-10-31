package com.survival.kotlinstudy.`03_encapsulation`

import com.survival.kotlinstudy.`03_encapsulation`.Wand.Companion.MAX_POWER
import com.survival.kotlinstudy.`03_encapsulation`.Wand.Companion.MIN_POWER
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


class WandTest {

    @Test
    fun `Wand 인스턴스 생성`() {
        // given (준비)
        val name = "사탕 지팡이"
        val power = 5.0
        val wand = Wand(name = name, power = power)

        // when (실행)

        // then (검증)
        assertEquals(name, wand.name)
        assertEquals(power, wand.power)
    }

    @Test
    fun `Wand의 이름이 3글자 미만이면 예외가 발생한다`() {
        val name = "사탕 지팡이"
        val power = 5.0
        // given (준비)
        val wand = Wand(name = name, power = power)
        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wand.name = "사탕"
        }
        // then (검증)
        assertEquals("지팡이의 이름은 3글자 이상이어야 합니다", exception.message)
    }

    @Test
    fun `Wand의 이름이 null 이면 예외가 발생한다`() {
        // given (준비)
        val name = "사탕 지팡이"
        val power = 5.0
        val wand = Wand(name = name, power = power)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wand.name = ""
        }
        // then (검증)
        assertEquals("지팡이의 이름은 null 일 수 없습니다", exception.message)
    }

    @Test
    fun `Wand의 마력은 MIN_POWER 이상이어야 한다`() {
        // given (준비)
        val name = "사탕 지팡이"
        val power = 5.0
        val wand = Wand(name = name, power = power)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wand.power = MIN_POWER - 1
        }
        // then (검증)
        assertEquals("지팡이의 마력은 $MIN_POWER 이상이어야 한다", exception.message)
    }

    @Test
    fun `Wand의 마력은 MAX_POWER 이하이어야 한다`() {
        // given (준비)
        val name = "사탕 지팡이"
        val power = 5.0
        val wand = Wand(name = name, power = power)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wand.power = MAX_POWER + 1
        }
        // then (검증)
        assertEquals("지팡이의 마력은 $MAX_POWER 이하여야 한다", exception.message)
    }

}