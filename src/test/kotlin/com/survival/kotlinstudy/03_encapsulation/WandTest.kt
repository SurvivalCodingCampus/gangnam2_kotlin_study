package com.survival.kotlinstudy.`03_encapsulation`

import org.junit.Test
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

}