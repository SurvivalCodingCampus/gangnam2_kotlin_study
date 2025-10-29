package com.sesac.practice.day02

import org.junit.Test
import kotlin.test.assertEquals

class ClericTest {
    @Test
    fun `Cleric을 생성한다`() {
        // given // when
        val cleric = Cleric("test", 1, 2)

        // then
        assertEquals("test", cleric.name)
        assertEquals(1, cleric.hp)
        assertEquals(2, cleric.mp)
    }

    @Test
    fun `Cleric을 생성하면 초기 hp는 50이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric을 생성하면 최대 hp는 50이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(50, cleric.maxHp)
    }

    @Test
    fun `Cleric을 생성하면 초기 mp는 10이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(10, cleric.mp)
    }

    @Test
    fun `Cleric을 생성하면 최대 mp는 50이다`() {
        // given // when
        val cleric = Cleric("test")

        // then
        assertEquals(10, cleric.maxMp)
    }

    @Test
    fun `selfAid 사용시 mp를 5 소비한다`() {
        // given
        val cleric = Cleric("test")

        // when
        cleric.selfAid()

        // then
        assertEquals(5, cleric.mp)
    }

    @Test
    fun `selfAid 사용시 hp가 최대 hp까지 회복한다`() {
        // given
        val cleric = Cleric("test", 10)

        // when
        cleric.selfAid()

        // then
        assertEquals(cleric.maxHp, cleric.hp)
    }

    @Test
    fun `selfAid 사용시 mp가 5보다 작으면 hp 회복이 되지 않는다`() {
        // given
        val cleric = Cleric("test", 10, 4)

        // when
        cleric.selfAid()

        // then
        assertEquals(10, cleric.hp)
    }
}
