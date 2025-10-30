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
        val hpAmount = 10
        val mpAmount = 3
        // given
        val cleric = Cleric(name = "루카", hp = hpAmount, mp = mpAmount)

        // when
        cleric.selfAid()

        // then
        assertEquals(hpAmount, cleric.hp)
        assertEquals(mpAmount, cleric.mp)
    }

    @Test
    fun `selfAid는 이미 HP가 최대일 때 실행되지 않는다`() {
        val mpAmount = 9

        // given
        val cleric = Cleric(name = "루카", hp = MAX_HP, mp = mpAmount)

        // when
        cleric.selfAid()

        // then
        assertEquals(MAX_HP, cleric.hp)
        assertEquals(mpAmount, cleric.mp)
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
        val mpAmount = 9
        // given
        val cleric = Cleric(name = "루카", mp = mpAmount)

        // when
        val recovered = cleric.pray(3)

        // then
        assertTrue(recovered in 1..MAX_MP - mpAmount)
        assertEquals(MAX_MP, cleric.mp)
    }

    @Test
    fun `생성자 확인`() {
        val deciededName = "루카"

        // name, hp = 40, mp = 5 지정
        val cleric = Cleric(name = deciededName, hp = 40, mp = 5)
        assertEquals(deciededName, cleric.name)
        assertEquals(40, cleric.hp)
        assertEquals(5, cleric.mp)

        // name, hp 35 지정 후 MP는 최대 MP로 초기화
        val cleric1 = Cleric(name = deciededName, hp = 35)
        assertEquals(deciededName, cleric1.name)
        assertEquals(35, cleric1.hp)
        assertEquals(MAX_MP, cleric1.mp)


        // name 만 지정 HP와 MP는 최대치로 초기화
        val cleric2 = Cleric(name = deciededName)
        assertEquals(deciededName, cleric2.name)
        assertEquals(MAX_HP, cleric2.hp)
        assertEquals(MAX_MP, cleric2.mp)
    }
}
