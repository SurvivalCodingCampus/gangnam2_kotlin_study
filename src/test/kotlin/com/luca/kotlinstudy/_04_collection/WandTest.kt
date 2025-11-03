package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._04_collection.WizardTest.Companion.availablePower
import com.luca.kotlinstudy._04_collection.WizardTest.Companion.invalidName
import com.luca.kotlinstudy._04_collection.WizardTest.Companion.invalidPower
import com.luca.kotlinstudy._04_collection.WizardTest.Companion.overPower
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class WandTest {
    @Test
    fun `완드 이름이 2글자 미만이면 예외가 발생한다`() {
        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Wand(name = invalidName, availablePower)
        }
    }

    @Test
    fun `완드 이름이 3글자 이상이면 정상적으로 설정된다`() {
        val wand = Wand(name = availableName, availablePower)
        assertEquals(availableName, wand.name)
    }

    @Test
    fun `완드 마력은 일정수치 미만이면 예외가 발생한다`() { // 0.4
        assertThrows(IllegalArgumentException::class.java) {
            Wand(name = availableName, power = invalidPower)
        }
    }

    @Test
    fun `완드 마력이 정상범주 일 때 설정된다`() { // 0.5 <= 정상범주 <=100
        val wand = Wand(name = availableName, power = availablePower)
        assertEquals(availablePower, wand.power,1e-9)
    }

    @Test
    fun `완드 마력은 정상범주(100)를 넘으면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Wand(name = availableName, power = overPower)
        }
    }
}