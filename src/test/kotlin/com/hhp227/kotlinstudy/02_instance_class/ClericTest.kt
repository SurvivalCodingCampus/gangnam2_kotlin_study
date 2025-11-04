package com.hhp227.kotlinstudy.`02_instance_class`

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ClericTest {
    @Test
    fun `Cleric의 초기 hp는 50이다`() {
        val cleric = Practice("용사")

        assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 초기 mp는 10이다`() {
        val cleric = Practice("용사")

        assertEquals(10, cleric.mp)
    }

    @Test
    fun `Cleric의 selfAid메소드를 실행하면 mp가 5감소하고 hp가 최대로 회복된다`() {
        // given (준비)
        val cleric = Practice("용사", mp = 30)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(25, cleric.mp)
        assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 pray메소드를 호출하면 time만큼 0~2보정된 값으로 회복된 후 반환된다`() {
        val cleric = Practice("용사", mp = 2)

        assertTrue((3..<6).contains(cleric.pray(3)))
        assertTrue((5..<8).contains(cleric.mp))

        cleric.mp = 51

        assertEquals(0, cleric.pray(0))
        assertEquals(10, cleric.mp)

        cleric.mp = 1

        assertEquals(9, cleric.pray(11))
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `이름, HP, MP를 지정하여 인스턴스화 할 수 있다`() {
        val cleric = Practice("아서스", hp = 40, mp = 5)

        assertIs<Practice>(cleric)
        assertEquals(40, cleric.hp)
        assertEquals(5, cleric.mp)
    }

    @Test
    fun `이름과 HP만으로 지정하여 인스턴스화 할 수 있다 이때, MP는 최대 MP와 같은 값이 초기화 된다`() {
        val cleric = Practice("아서스", hp = 35)

        assertIs<Practice>(cleric)
        assertEquals(35, cleric.hp)
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `이름만을 지정하여 인스턴스화 할 수 있다 이때, HP와 MP는 최대 HP와 최대 MP로 초기화 된다`() {
        val cleric = Practice("아서스")

        assertIs<Practice>(cleric)
        assertEquals(50, cleric.hp)
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `이름을 지정하지 않는 경우에는 인스턴스화 할 수 없다`() {
        assertFailsWith<Exception> { Practice() }
    }
}