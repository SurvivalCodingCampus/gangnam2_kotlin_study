package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class WandTest {

    @Test
    fun `지팡이가 잘 생성되는지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        assertEquals(wand.name, "나뭇가지")
        assertEquals(wand.power, 0.6)
    }

    @Test
    fun `지팡이의 이름이 3자 이상인지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        val exception = assertThrows<IllegalArgumentException> {
            wand.name = "나무"
        }

        assertEquals(exception.message, "이름이 3자 이상이어야 합니다.")
    }

    @Test
    fun `지팡이의 이름이 8자 이하인지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        val exception = assertThrows<IllegalArgumentException> {
            wand.name = "바오밥나무 지팡이"
        }

        assertEquals(exception.message, "이름이 8자 이하이어야 합니다.")
    }

    @Test
    fun `이름에 공백이 있는지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        val exception = assertThrows<IllegalArgumentException> {
            wand.name = "고목나무 지팡이"
        }

        assertEquals(exception.message, "이름에 공백이 포함되어 있습니다.")
    }

    @Test
    fun `이름에 특수문자가 포함 되었는지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        val exception = assertThrows<IllegalArgumentException> {
            wand.name = "지팡이!"
        }

        assertEquals(exception.message, "이름에 특수문자가 포함되어 있습니다.")
    }

    @Test
    fun `마력 범위가 잘 정해졌는지 확인`() {
        val wand = Wand(DEFAULT_WAND_NAME, DEFAULT_WAND_POWER)

        val exception = assertThrows<IllegalArgumentException> {
            wand.power = 0.4
        }

        assertEquals(exception.message, "주어진 마력의 범위와 다릅니다.")
    }

    companion object {
        const val DEFAULT_WAND_NAME = "나뭇가지"
        const val DEFAULT_WAND_POWER = 0.6
    }
}