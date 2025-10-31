package com.neouul.sesac.`04-encapsulation`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WandTest {
    companion object{
        const val NAME = "ABC"
    }

    @Test
    fun `Wand의 인스턴스가 정상적으로 생성된다`() {
        val wand = Wand(NAME, 10.0)

        assertEquals(NAME, wand.name)
        assertEquals(10.0, wand.power)
    }

    @Test
    fun `Wand의 power 필드 경계값 분석 - 하한 경계`() {
        // 마력 0.5로 인스턴스 생성
        val wand = Wand(NAME, MIN_WAND_POWER)

        // 하한 경계
        assertFailsWith<IllegalArgumentException> { wand.power-- }     // -0.5
        assertEquals(MIN_WAND_POWER, wand.power)    // 0.5
        wand.power++
        assertEquals(MIN_WAND_POWER + 1, wand.power)    // 1.5
    }

    @Test
    fun `Wand의 power 필드 경계값 분석 - 상한 경계`() {
        // 마력 99.0로 인스턴스 생성
        val wand = Wand(NAME, MAX_WAND_POWER - 1)

        // 상한 경계
        assertEquals(MAX_WAND_POWER - 1, wand.power)    // 99.0
        wand.power++
        assertEquals(MAX_WAND_POWER, wand.power)    // 100.0
        assertFailsWith<IllegalArgumentException> { wand.power++ }     // 101.0
    }

}