package com.neouul.sesac.`05-abstract-interface`

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

    @Test
    fun `Computer이 인터페이스 Thing의 weight를 잘 구현하고 있는가`() {
        // given
        val computer = Computer("갤럭시북", 2000000, "white", "samsung", 1.4)

        // when: Double형의 weight에게는 getter/setter가 존재한다 = var이다
        computer.weight = 1.0

        // then
        assertTrue(computer is Thing)
        assertEquals(1.0, computer.weight, 1e-9)
    }
}