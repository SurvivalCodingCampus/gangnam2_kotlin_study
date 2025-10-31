package com.sesac.practice.day04

import org.junit.Test
import kotlin.test.assertEquals

class WandTest {
    @Test
    fun `Wand를 생성한다`() {
        // given
        val name = "wand"
        val power = 1.1

        // when
        val wand = Wand(name, power)

        // then
        assertEquals(name, wand.name)
        assertEquals(power, wand.power)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wand 이름이 3자 미만일 경우 에러가 발생한다`() {
        // given
        val name = "ab"
        val power = 1.1

        // when // then
        Wand(name, power)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wand 마력이 0_5 미만일 경우 에러가 발생한다`() {
        // given
        val name = "wand"
        val power = 0.4

        // when // then
        Wand(name, power)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Wand 마력이 100 초과 경우 에러가 발생한다`() {
        // given
        val name = "wand"
        val power = 100.1

        // when // then
        Wand(name, power)
    }
}
