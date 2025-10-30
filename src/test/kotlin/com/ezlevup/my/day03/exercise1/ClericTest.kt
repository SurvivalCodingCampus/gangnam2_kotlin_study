package com.ezlevup.my.day03.exercise1

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ClericTest {
    @Test
    fun `성직자 인스턴스 초기값 확인`() {
        // given
        val cleric = Cleric(name = "lee")

        // then
        assertEquals(50, cleric.hp)
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `성직자 셀프 에이드 마법 사용`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = cleric.MAX_HP - 1
        cleric.mp = cleric.MAX_MP

        // when
        cleric.selfAid()

        // then
        assertEquals(cleric.MAX_HP, cleric.hp)
        assertEquals(cleric.MAX_MP - cleric.SELF_AID_MP_COST, cleric.mp)
    }

    @Test
    fun `성직자 기도하기 행동`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = cleric.MAX_HP
        cleric.mp = cleric.MAX_MP - 10

        // when
        cleric.pray(10)

        // then
        assertEquals(cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `성직자 MP를 지정된 양만큼 소모 성공`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = cleric.MAX_HP
        cleric.mp = cleric.MAX_MP

        // when
        val result: Boolean = cleric.useMp(5)

        // then
        assertEquals(true, result)
        assertEquals(cleric.MAX_MP - 5, cleric.mp)
    }

    @Test
    fun `성직자 MP를 지정된 양만큼 소모 실패`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = 1
        cleric.mp = 1

        // when
        val result: Boolean = cleric.useMp(5)

        // then
        assertEquals(false, result)
        assertEquals(1, cleric.mp)
    }

    @Test
    fun `성직자 MP를 회복 test 1`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = cleric.MAX_HP
        cleric.mp = cleric.MAX_MP - 1

        // when
        cleric.recoverMp(10)

        // then
        assertEquals(cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `성직자 MP를 회복 test 2`() {
        // given
        val cleric = Cleric(name = "lee")
        cleric.hp = 0
        cleric.mp = 0

        // when
        cleric.recoverMp(10)

        // then
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `성직자 prayBonus는 0이상 2이하의 값을 반환한다`() {
        // given
        val cleric = Cleric(name = "lee")

        repeat(100) {
            // when
            val value = cleric.prayBonus()

            // then
            assertTrue("prayBonus 결과가 0~2 범위 밖입니다: $value", value in 0..2)
        }
    }
}
