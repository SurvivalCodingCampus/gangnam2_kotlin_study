package com.survival.kotlinstudy.`06_interface`

import org.junit.Test
import kotlin.test.assertEquals

class ComputerTest {

    @Test
    fun `Computer 인스턴스 생성 테스트`() {

        // given (준비)
        val name = "책"
        val price = 10000
        val color = "Black"
        val markerName = "markerName"
        val computer = Computer(name = name, price = price, color = color, markerName = markerName)

        // when (실행)

        // then (검증)
        assertEquals(name, computer.name)
        assertEquals(price, computer.price)
        assertEquals(color, computer.color)
        assertEquals(markerName, computer.markerName)
    }
}