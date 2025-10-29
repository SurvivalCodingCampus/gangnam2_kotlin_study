package com.survival.kotlinstudy.`02_instance_class`

import org.junit.Test
import kotlin.test.assertEquals

class ClericTest {

    @Test
    fun `Cleric 클래스 선언 시 초기 HP MP, 최대 HP MP 확인하기`() {
        val cleric = Cleric(name = "성직자")
        assertEquals(50,cleric.hp)
        assertEquals(50,cleric.maxHp)
        assertEquals(10,cleric.mp)
        assertEquals(10,cleric.maxMp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 5 감소하고 HP는 최대 HP가 된다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자", hp = 20)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(5, cleric.mp)
        assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 5일 경우 HP가 회복되어야 한다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자", hp = 10, mp = 5)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(0, cleric.mp)
        assertEquals(50, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 5보다 작다면 HP가 회복되지 않음`() {
        // given (준비)
        val cleric = Cleric(name = "성직자", hp = 20, mp = 3)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(3, cleric.mp)
        assertEquals(20, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 HP가 최대일 경우 최대HP를 넘어가면 안된다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자", hp = 50, mp = 10)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(5, cleric.mp)
        assertEquals(50, cleric.hp)
    }


    @Test
    fun `pray() 메서드 실행 시 MP를 회복해야 한다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자",mp = 5)

        // when (실행)
        cleric.pray(3)

        // then (검증)
        assertEquals(8, cleric.mp)
    }

    @Test
    fun `pray() 메서드 실행 시 최대 MP 보다 더 회복하는 것은 불가능하다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자")

        // when (실행)
        val actually = cleric.pray(3)

        // then (검증)
        assertEquals(10, cleric.mp)
        assertEquals(0, actually)
    }
}