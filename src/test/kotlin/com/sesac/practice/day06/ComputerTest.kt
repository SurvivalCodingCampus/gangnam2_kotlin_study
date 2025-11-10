package com.sesac.practice.day06

import org.junit.Assert.assertEquals
import org.junit.Test

class ComputerTest {
    @Test
    fun `Computer를 생성한다`() {
        // given
        val name = "computer"
        val price = 100
        val color = "#112233"
        val makerName = "apple"

        // when
        val computer = Computer(name, price, color, makerName)

        // then
        assertEquals(name, computer.name)
        assertEquals(price, computer.price)
        assertEquals(color, computer.color)
        assertEquals(makerName, computer.makerName)
        assertEquals(Computer.COMPUTER_WEIGHT, computer.weight, 0.0)
    }

    @Test
    fun `Computer의 무게를 수정한다`() {
        // given
        val name = "computer"
        val price = 100
        val color = "#112233"
        val makerName = "apple"

        val computer = Computer(name, price, color, makerName)

        // when
        val weight = 1.1
        computer.weight = weight

        // then
        assertEquals(weight, computer.weight, 0.0)
    }
}
