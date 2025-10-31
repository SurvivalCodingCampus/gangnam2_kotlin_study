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
}
