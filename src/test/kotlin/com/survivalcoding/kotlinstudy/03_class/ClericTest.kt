package com.survivalcoding.kotlinstudy.`03_class`

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ClericTest {
    @Test
    fun `Cleric 생성 조건 케이스`() {
        // 이름만 지정
        // given(준비)
        val case1 = Cleric("아서스")

        // then(검증)
        assertEquals(50, case1.hp)
        assertEquals(10, case1.mp)

        // 최대 MP로 초기화
        // given(준비)
        val case2 = Cleric("아서스", hp = 35)

        // then(검증)
        assertEquals(35, case2.hp)
        assertEquals(10, case2.mp)

        // HP, MP 지정하여 인스턴스화
        // given(준비)
        val case3 = Cleric("아서스", hp = 40, mp = 5)

        // then(검증)
        assertEquals(40, case3.hp)
        assertEquals(5, case3.mp)

    }

    @Test
    fun `이름 없이 Cleric 생성 불가`() {
        // Cleric()
        // 컴파일 타임에 막히므로 실행 테스트는 불가
        // 이름 없는 생성자 호출 시 IDE 컴파일 에러 확인
        assertTrue(true)
    }


    // SelfAid 스킬
    @Test
    fun `selfAid 스킬 정상 사용`() {
        // given
        val cleric = Cleric("아서스", hp = 30, mp = 10)

        // when
        cleric.selfAid()

        // then
        assertEquals(5, cleric.mp)     // 5 소모
        assertEquals(50, cleric.hp)    // HP 완전 회복
    }

    @Test
    fun `selfAid 스킬 실패 - MP 부족`() {
        // given
        val cleric = Cleric("아서스", hp = 30, mp = 4)

        // when
        cleric.selfAid()

        // then
        assertEquals(4, cleric.mp)     // MP 변화 없음
        assertEquals(30, cleric.hp)    // HP 변화 없음
    }

    @Test
    fun `selfAid 스킬 실패 - HP 이미 최대`() {
        // given
        val cleric = Cleric("아서스", hp = 50, mp = 10)

        // when
        cleric.selfAid()

        // then
        assertEquals(10, cleric.mp)    // MP 소비되지 않음
        assertEquals(50, cleric.hp)    // HP 그대로 유지
    }

    @Test
    fun `selfAid 스킬 - MP 정확히 5`() {
        // given
        val cleric = Cleric("아서스", hp = 20, mp = 5)

        // when
        cleric.selfAid()

        // then
        assertEquals(0, cleric.mp)     // 정확히 5 소모
        assertEquals(50, cleric.hp)    // HP 완전 회복
    }
}