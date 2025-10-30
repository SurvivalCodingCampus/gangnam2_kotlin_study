package com.sesac.practice.day03

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClericTest {
    @Test
    fun `Cleric을 생성한다`() {
        // given // when
        val cleric = Cleric("test", 1, 2)

        // then
        assertEquals("test", cleric.name)
        assertEquals(1, cleric.hp)
        assertEquals(2, cleric.mp)
        assertEquals(50, Cleric.MAX_HP)
        assertEquals(10, Cleric.MAX_MP)
        assertEquals(5, Cleric.SELF_AID_MP_COST)
        assertEquals(0, Cleric.PRAY_MIN_REGEN_AMOUNT)
        assertEquals(2, Cleric.PRAY_MAX_REGEN_AMOUNT)
    }

    @Test
    fun `Cleric을 생성하면 초기 hp는 최대 hp이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }

    @Test
    fun `Cleric을 생성하면 초기 mp는 최대 mp이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `selfAid 사용시 mp를 소비한다`() {
        // given
        val cleric = Cleric("test")
        val originMp = cleric.mp

        // when
        cleric.selfAid()

        // then
        assertEquals(originMp - Cleric.SELF_AID_MP_COST, cleric.mp)
    }

    @Test
    fun `selfAid 사용시 hp가 최대 hp까지 회복한다`() {
        // given
        val cleric = Cleric("test")

        // when
        cleric.selfAid()

        // then
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }

    @Test(expected = IllegalStateException::class)
    fun `selfAid 사용시 mp가 소비량 보다 작으면 hp 회복이 되지 않는다`() {
        // given
        val hp = 10
        val mp = Cleric.SELF_AID_MP_COST - 1
        val cleric = Cleric("test", hp, mp)

        // when // then
        cleric.selfAid()
    }

    @Test
    fun `pray 사용시 mp가 회복된다`() {
        // given
        val mp = 0
        val cleric = Cleric(name = "test", mp = mp)

        // when
        val recoveredMp = cleric.pray()

        // then
        val expectedRegenRange = Cleric.PRAY_MIN_REGEN_AMOUNT..Cleric.PRAY_MAX_REGEN_AMOUNT

        assertTrue(recoveredMp in expectedRegenRange)
        assertTrue(cleric.mp in expectedRegenRange)
    }

    @Test
    fun `pray 사용시 기도한 시간만큼 더 회복된다`() {
        // given
        val mp = 0
        val cleric = Cleric(name = "test", mp = mp)

        // when
        val castingTime = 3

        val recoveredMp = cleric.pray(castingTime)

        // then
        val expectedRegenRange = Cleric.PRAY_MIN_REGEN_AMOUNT + castingTime..Cleric.PRAY_MAX_REGEN_AMOUNT + castingTime

        assertTrue(recoveredMp in expectedRegenRange)
        assertTrue(cleric.mp in expectedRegenRange)
    }

    @Test
    fun `pray 사용시 mp가 최대 mp까지 회복된다`() {
        // given
        val mp = Cleric.MAX_MP
        val cleric = Cleric(name = "test", mp = mp)

        // when
        cleric.pray(100)

        // then
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `pray 사용시 기도한 시간이 음수일 경우 0이 반환된다`() {
        // given
        val cleric = Cleric(name = "test")

        // when // then
        cleric.pray(-3)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `pray 사용시 기도한 시간이 너무 클 경우 0이 반환된다`() {
        // given
        val cleric = Cleric(name = "test")

        // when // then
        cleric.pray(Int.MAX_VALUE)
    }
}
