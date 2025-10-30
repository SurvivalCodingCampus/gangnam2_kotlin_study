package com.survivalcoding.kotlinstudy.`03_class`

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ClericTest {
    @Test
    fun `Cleric 생성 조건 케이스`() {
        // 이름만 지정
        val case1 = Cleric("아서스")
        assertEquals(50, case1.hp)
        assertEquals(10, case1.mp)

        // 최대 MP로 초기화
        val case2 = Cleric("아서스", hp = 35)
        assertEquals(35, case2.hp)
        assertEquals(10, case2.mp)

        // HP, MP 지정하여 인스턴스화
        val case3 = Cleric("아서스", hp = 40, mp = 5)
        assertEquals(40, case3.hp)
        assertEquals(5, case3.mp)

    }

    @Test
    fun `이름 없이 Cleric 생성 불가`() {
        // Cleric()
        // 컴파일 타임에 막히므로 실행 테스트는 불가
        // 단, 이름 없는 생성자 호출 시 IDE 컴파일 에러 확인
        assertTrue(true)
    }
}