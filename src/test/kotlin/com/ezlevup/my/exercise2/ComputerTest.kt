package com.ezlevup.my.exercise2

import org.junit.Assert.assertEquals
import org.junit.Test

class ComputerTest {
    @Test
    fun `책 생성자`() {
        // given
        val name = "게임 PC"
        val price = 2300000
        val color = "pink"
        val makerName = "lee"
        val computer = Computer(name = name, price = price, color = color, makerName = makerName)

        // then
        assertEquals(name, computer.name)
        assertEquals(price, computer.price)
        assertEquals(color, computer.color)
        assertEquals(makerName, computer.makerName)
    }
}