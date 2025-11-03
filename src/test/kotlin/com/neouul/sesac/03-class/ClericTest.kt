package com.neouul.sesac.`03-class`

import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertEquals

class ClericTest {
    @Test
    fun `Cleric 생성자가 연습문제 2-A를 만족하는지`() {
        val cleric = Cleric(name = "아서스", hp = 40, mp = 5)

        // then
        assertEquals("아서스", cleric.name)
        assertEquals(40, cleric.hp)
        assertEquals(5, cleric.mp)
    }

    @Test
    fun `Cleric 생성자가 연습문제 2-B를 만족하는지`() {
        val cleric = Cleric(name = "아서스", hp = 35)

        assertEquals("아서스", cleric.name)
        assertEquals(35, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `Cleric 생성자가 연습문제 2-C를 만족하는지`() {
        val cleric = Cleric(name = "아서스")

        assertEquals("아서스", cleric.name)
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }
}