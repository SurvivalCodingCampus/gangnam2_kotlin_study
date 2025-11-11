package com.neouul.sesac.`03-encapsulation`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

// Top-Level 상수
const val VALID_NAME = "ABC"
const val VALID_POWER = 10.0


// 생성자에 들어온 인자의 유효성 검사
class WandConstructorTest {
    @Test
    fun `Wand의 인스턴스가 정상적으로 생성된다`() {
        val wand = Wand(VALID_NAME, VALID_POWER)

        assertEquals(VALID_NAME, wand.name)
        assertEquals(VALID_POWER, wand.power)
    }

    @Test
    fun `Wand의 생성자에 3문자 미만의 이름이 전달되어, 인스턴스 생성에 실패한다`() {
        assertFailsWith<IllegalArgumentException> { val wand = Wand("A", VALID_POWER) }
        assertFailsWith<IllegalArgumentException> { val wand = Wand("AB", VALID_POWER) }
    }

    @Test
    fun `Wand의 생성자 파라미터 power 경계값 분석 - 하한 경계`() {
        assertFailsWith<IllegalArgumentException> { Wand(VALID_NAME, MIN_WAND_POWER - 1) }     // -0.5
        assertEquals(MIN_WAND_POWER, Wand(VALID_NAME, MIN_WAND_POWER).power)    // 0.5
        assertEquals(MIN_WAND_POWER + 1, Wand(VALID_NAME, MIN_WAND_POWER + 1).power)    // 1.5
    }

    @Test
    fun `Wand의 생성자 파라미터 power 경계값 분석 - 상한 경계`() {
        assertEquals(MAX_WAND_POWER - 1, Wand(VALID_NAME, MAX_WAND_POWER - 1).power)    // 99.0
        assertEquals(MAX_WAND_POWER, Wand(VALID_NAME, MAX_WAND_POWER).power)    // 100.0
        assertFailsWith<IllegalArgumentException> { Wand(VALID_NAME, MAX_WAND_POWER + 1) }      // 101.0
    }
}

// setter 재정의 테스트
class WandFieldTest {
    @Test
    fun `Wand의 name 필드 경계값 분석`() {
        val wand = Wand(VALID_NAME, VALID_POWER)

        assertFailsWith<IllegalArgumentException> { wand.name = "AB" }   // 2
        assertEquals(VALID_NAME, wand.name)     // 3
        wand.name += "D"
        assertEquals("ABCD", wand.name)     // 4
    }

    @Test
    fun `Wand의 power 필드 경계값 분석 - 하한 경계`() {
        // 마력 0.5로 인스턴스 생성
        val wand = Wand(VALID_NAME, MIN_WAND_POWER)

        // 하한 경계
        assertFailsWith<IllegalArgumentException> { wand.power-- }     // -0.5
        assertEquals(MIN_WAND_POWER, wand.power)    // 0.5
        wand.power++
        assertEquals(MIN_WAND_POWER + 1, wand.power)    // 1.5
    }

    @Test
    fun `Wand의 power 필드 경계값 분석 - 상한 경계`() {
        // 마력 99.0로 인스턴스 생성
        val wand = Wand(VALID_NAME, MAX_WAND_POWER - 1)

        // 상한 경계
        assertEquals(MAX_WAND_POWER - 1, wand.power)    // 99.0
        wand.power++
        assertEquals(MAX_WAND_POWER, wand.power)    // 100.0
        assertFailsWith<IllegalArgumentException> { wand.power++ }     // 101.0
    }
}