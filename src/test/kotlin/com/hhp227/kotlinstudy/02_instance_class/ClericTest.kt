package com.hhp227.kotlinstudy.`02_instance_class`

import junit.framework.TestCase
import kotlin.test.Test

class ClericTest {
    @Test
    fun `Cleric의 초기 hp는 50이다`() {
        val cleric = Cleric()

        TestCase.assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 초기 mp는 10이다`() {
        val cleric = Cleric()

        TestCase.assertEquals(10, cleric.mp)
    }

    @Test
    fun `Cleric의 selfAid메소드를 실행하면 mp가 5감소하고 hp가 최대로 회복된다`() {
        // given (준비)
        val cleric = Cleric(mp = 30)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        TestCase.assertEquals(25, cleric.mp)
        TestCase.assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 pray메소드를 호출하면 time만큼 0~2보정된 값으로 회복된 후 반환된다`() {
        val cleric = Cleric(mp = 2)

        TestCase.assertTrue((3..<6).contains(cleric.pray(3)))
        TestCase.assertTrue((5..<8).contains(cleric.mp))

        cleric.mp = 51

        TestCase.assertEquals(0, cleric.pray(0))
        TestCase.assertEquals(10, cleric.mp)

        cleric.mp = 1

        TestCase.assertEquals(10, cleric.pray(11))
        TestCase.assertEquals(10, cleric.mp)
    }
}