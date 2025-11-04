package com.neouul.sesac.`06-abstract-interface`

import org.junit.Assert.*
import org.junit.Test

class ComputerTest {
    @Test
    fun `Computer의 인스턴스가 추상클래스와 인스턴스를 잘 구현하고 있는가`() {
        // given
        val computer = Computer("갤럭시북", 2000000, "white", "samsung", 1.4)

        // then
        assertEquals("갤럭시북", computer.name)
        assertEquals(2000000, computer.price)
        assertEquals("white", computer.color)
        assertEquals("samsung", computer.makerName)
        assertEquals(1.4, computer.weight, 1e-9)

        assertTrue(computer is TangibleAsset)
        assertTrue(computer is Thing)
        assertTrue(computer is Asset)
    }
}