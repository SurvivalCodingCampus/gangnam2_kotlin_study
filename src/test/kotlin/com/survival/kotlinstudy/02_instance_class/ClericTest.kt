package com.survival.kotlinstudy.`02_instance_class`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val name = "아서스"

class ClericTest {

    @Test
    fun `Cleric 클래스 선언 시 초기 HP, MP, 이름 확인하기`() {
        val cleric = Cleric(name = name)
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
        assertEquals(name, cleric.name)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 5 감소하고 HP는 최대 HP가 된다`() {
        // given (준비)
        val hp = 20
        val cleric = Cleric(name = name, hp = hp)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(5, cleric.mp)
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 5일 경우 HP가 회복되어야 한다`() {
        // given (준비)
        val hp = 20
        val mp = 5
        val cleric = Cleric(name = name, hp = hp, mp = mp)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(0, cleric.mp)
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 MP가 4라면 HP가 회복되지 않음`() {
        // given (준비)
        val hp = 20
        val mp = 4
        val cleric = Cleric(name = name, hp = hp, mp = mp)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(mp, cleric.mp)
        assertEquals(hp, cleric.hp)
    }

    @Test
    fun `Cleric의 selfAid() 메서드 실행 시 HP가 최대일 경우 최대HP를 넘어가면 안된다`() {
        // given (준비)
        val cleric = Cleric(name = name)

        // when (실행)
        cleric.selfAid()

        // then (검증)
        assertEquals(5, cleric.mp)
        assertEquals(Cleric.MAX_HP, cleric.hp)
    }


    @Test
    fun `pray() 메서드 실행 시 3초 이후에는 3~5 만큼 MP를 회복해야 한다`() {
        // given (준비)
        val mp = 5
        val cleric = Cleric(name = name, mp = mp)

        // when (실행)
        val actually = cleric.pray(3)

        // then (검증)
        assertTrue(actually in 3..5)
    }

    @Test
    fun `pray() 메서드 실행 시 최대 MP 보다 더 회복하는 것은 불가능하다`() {
        // given (준비)
        val cleric = Cleric(name = "성직자")

        // when (실행)
        val actually = cleric.pray(3)

        // then (검증)
        assertEquals(Cleric.MAX_MP, cleric.mp)
        assertEquals(0, actually)
    }

    @Test
    fun `pray() 메서드 실행 시 기도 시간은 0초 라면 회복하지 않는다`() {
        // given (준비)
        val time = 0
        val mp = 5
        val cleric = Cleric(name = name, mp = mp)

        // when (실행)
        val actually = cleric.pray(time)

        // then (검증)
        assertEquals(mp, cleric.mp)
        assertEquals(0, actually)
    }

    @Test
    fun `pray() 메서드 실행 시 MP가 최대일 경우 테스트`() {
        // given (준비)
        val cleric = Cleric(name = name)

        // when (실행)
        val actually = cleric.pray(3)

        // then (검증)
        assertEquals(Cleric.MAX_MP, cleric.mp)
        assertEquals(0, actually)
    }

    @Test
    fun `Cleric() 클래스 선언 시 이름, HP, MP 를 지정하여 인스턴스 테스트`() {
        // given (준비)
        val hp = 40
        val mp = 5
        val cleric = Cleric(name = name, hp = hp, mp = mp)

        // when (실행)

        // then (검증)
        assertEquals(name, cleric.name)
        assertEquals(hp, cleric.hp)
        assertEquals(mp, cleric.mp)
    }

    @Test
    fun `Cleric() 클래스 선언 시 이름, HP만 지정하고 MP는 최대 MP인지 테스트`() {
        // given (준비)
        val hp = 35
        val cleric = Cleric(name = name, hp = hp)

        // when (실행)

        // then (검증)
        assertEquals(name, cleric.name)
        assertEquals(hp, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }

    @Test
    fun `Cleric() 클래스 선언 시 이름만 지정하고 HP는 최대 HP, MP는 최대 MP인지 테스트`() {
        // given (준비)
        val cleric = Cleric(name = name)

        // when (실행)

        // then (검증)
        assertEquals(name, cleric.name)
        assertEquals(Cleric.MAX_HP, cleric.hp)
        assertEquals(Cleric.MAX_MP, cleric.mp)
    }
}