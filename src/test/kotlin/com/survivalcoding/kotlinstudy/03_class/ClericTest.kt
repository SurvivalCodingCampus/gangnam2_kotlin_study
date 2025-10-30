package com.survivalcoding.kotlinstudy.`03_class`

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

// Cleric 생성 테스트
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
}

// SelfAid 스킬 테스트
class SelfAidTest {
    @Test
    fun `selfAid 스킬 정상 사용`() {
        // given(준비)
        val cleric = Cleric("아서스", hp = 30, mp = 10)

        // when(실행)
        cleric.selfAid()

        // then(검증)
        assertEquals(5, cleric.mp) // 5 소모
        assertEquals(50, cleric.hp) // HP 완전 회복
    }

    // MP 부족
    @Test
    fun `selfAid 스킬 실패 - MP 부족`() {
        // given(준비)
        val cleric = Cleric("아서스", hp = 30, mp = 4)

        // when(실행)
        cleric.selfAid()

        // then(검증)
        assertEquals(4, cleric.mp) // MP 변화 없음
        assertEquals(30, cleric.hp) // HP 변화 없음
    }

    // HP 최대
    @Test
    fun `selfAid 스킬 실패 - HP 이미 최대`() {
        // given(준비)
        val cleric = Cleric("아서스", hp = 50, mp = 10)

        // when(실행)
        cleric.selfAid()

        // then(검증)
        assertEquals(10, cleric.mp) // MP 소비되지 않음
        assertEquals(50, cleric.hp) // HP 그대로 유지
    }

    // 정상
    @Test
    fun `selfAid 스킬 성공 - MP 정확히 5`() {
        // given(준비)
        val cleric = Cleric("아서스", hp = 20, mp = 5)

        // when(실행)
        cleric.selfAid()

        // then(검증)
        assertEquals(0, cleric.mp) // 정확히 5 소모
        assertEquals(50, cleric.hp) // HP 완전 회복
    }
}

// Pray 스킬 테스트
class ClericPrayTest {
    @Test
    fun `pray 정상`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 5)

        // when(실행)
        val recovery = cleric.pray(2)

        // then(검증)
        assertTrue(recovery in 2..4) // 2~4 사이 회복
        assertTrue(cleric.mp in 7..9) // 최대 MP 초과 없음
    }

    // 최대 MP
    @Test
    fun `pray 스킬 실패 - 최대 MP`() {
        // given(준비)
        val cleric = Cleric("아서스")

        // when(실행)
        val recovery = cleric.pray(3)

        // then(검증)
        assertEquals(0, recovery) // 회복 불가
        assertEquals(10, cleric.mp) // MP 그대로 유지
    }

    // 1초 기도 (최소값)
    @Test
    fun `pray 스킬 성공 - 1초 기도`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 5)

        // when(실행)
        val recovery = cleric.pray(1)

        // then(검증)
        assertTrue(recovery in 1..3) // 최소값 1~3 범위
        assertTrue(cleric.mp in 6..8) // MP 회복
    }

    // 0초 기도 (경계)
    @Test
    fun `pray 스킬 실패 - 0초 기도`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 5)

        // when(실행)
        val recovery = cleric.pray(0)

        // then(검증)
        assertEquals(0, recovery)
        assertEquals(5, cleric.mp) // 변화 없음
    }

    // 음수 기도 시간
    @Test
    fun `pray 스킬 실패 - 음수 기도`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 5)

        // when(실행)
        val recovery = cleric.pray(-3)

        // then(검증)
        assertEquals(0, recovery)
        assertEquals(5, cleric.mp) // 변화 없음
    }

    // 회복량 초과 케이스
    @Test
    fun `pray 스킬 성공 - 회복량 초과`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 9)

        // when(실행)
        val recovery = cleric.pray(5)

        // then(검증)
        assertEquals(Cleric.MAX_MP, cleric.mp) // MP 최대치
        assertEquals(Cleric.MAX_MP - 9, recovery) // 실제 회복량 1
    }

    // MP 0일 때
    @Test
    fun `pray 스킬 성공 - MP 0일 때`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 0)

        // when(실행)
        val recovery = cleric.pray(3)

        // then(검증)
        assertTrue(recovery in 3..5)
        assertTrue(cleric.mp in 3..5)
    }

    // 연속 기도
    @Test
    fun `pray 스킬 성공 - 연속 기도`() {
        // given(준비)
        val cleric = Cleric("아서스", mp = 2)

        // when(실행)
        val first = cleric.pray(3)
        val second = cleric.pray(3)

        // then(검증)
        assertTrue(first >= 0)
        assertTrue(second >= 0)
        assertTrue(cleric.mp <= Cleric.MAX_MP)    // 누적 회복이 최대 MP 초과 안 함
    }
}
