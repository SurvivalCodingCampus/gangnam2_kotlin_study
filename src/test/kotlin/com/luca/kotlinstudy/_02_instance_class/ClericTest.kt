package com.luca.kotlinstudy._02_instance_class

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClericTest {

    @Test
    fun `selfAid를 사용하면 mp가 5 감소하고 hp가 최대치로 회복된다`() {
        // given
        val cleric = Cleric(name = "루카", hp = 30, mp = 10)

        // when
        cleric.selfAid()

        // then
        assertEquals(MAX_HP, cleric.hp)
        assertEquals(5, cleric.mp)
    }
    @Test
    fun `selfAid는 mp가 부족하면 실행되지 않는다`() {
        // given
        val cleric = Cleric(name = "루카", hp = 10, mp = 3)

        // when
        cleric.selfAid()

        // then
        assertEquals(10, cleric.hp)
        assertEquals(3, cleric.mp)
    }

    @Test
    fun `selfAid는 이미 HP가 최대일 때 실행되지 않는다`() {
        // given
        val cleric = Cleric(name = "루카", hp = MAX_HP, mp = 9)

        // when
        cleric.selfAid()

        // then
        assertEquals(MAX_HP, cleric.hp)
        assertEquals(9, cleric.mp)
        println(cleric.mp)
    }

    @Test
    fun `pray는 mp가 최대치일 때 회복하지 않는다`() {
        // given
        val cleric = Cleric(name = "루카", mp = MAX_MP)

        // when
        val recovered = cleric.pray(3)

        // then
        assertEquals(0, recovered)
        assertEquals(MAX_MP, cleric.mp)
    }

    @Test
    fun `pray로 회복 시 최대치를 넘지 않아야 한다`() {
        // given
        val cleric = Cleric(name = "루카", mp = 9)

        // when
        val recovered = cleric.pray(3)

        // then
        assertTrue(recovered in 1..MAX_MP - 9)
        assertEquals(MAX_MP, cleric.mp)
    }
}
