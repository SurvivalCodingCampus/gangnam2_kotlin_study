package com.neouul.sesac.`04-encapsulation`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class WandTest {



    @Test
    fun `Wand의 power 필드 경계값 분석 - 하한 경계`() {
        // 마력 0.5로 인스턴스 생성
        val wand = Wand("A", MIN_WAND_POWER)

        // 하한 경계
        assertFailsWith<IllegalArgumentException> { wand.power-- }     // -0.5
        assertEquals(MIN_WAND_POWER, wand.power)    // 0.5
        wand.power++
        assertEquals(MIN_WAND_POWER + 1, wand.power)    // 1.5
    }

    @Test
    fun `Wand의 power 필드 경계값 분석 - 상한 경계`() {
        // 마력 99.0로 인스턴스 생성
        val wand = Wand("A", MAX_WAND_POWER - 1)

        // 상한 경계
        assertEquals(MAX_WAND_POWER - 1, wand.power)    // 99.0
        wand.power++
        assertEquals(MAX_WAND_POWER, wand.power)    // 100.0
        assertFailsWith<IllegalArgumentException> { wand.power++ }     // 101.0
    }

}