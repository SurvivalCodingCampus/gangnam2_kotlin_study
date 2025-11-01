package com.luca.kotlinstudy._04_collection

import org.junit.Assert.*
import org.junit.Test

class WizardTest {
    @Test
    fun `위자드 이름이 3글자 미만이면 예외가 발생한다`() {
        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Wizard(name = invalidName)
        }
    }

    @Test
    fun `위자드 이름이 3글자 이상이면 정상적으로 설정된다`() {
        val wizard = Wizard(name = availableName)

        // when & then
        assertEquals(availableName, wizard.name)
    }

    @Test
    fun `MP가 0 미만이면 예외가 발생한다`() {
        // given
        val invalidMp = -50

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Wizard(name = availableName, mp = invalidMp)
        }
    }

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
            Wand(name = availableName, power = invaildPower)
        }
    }

    @Test
    fun `완드 마력이 정상범주 일 때  설정된다`() { // 0.5
        val wand = Wand(name = availableName, power = availablePower)
        assertEquals(availablePower, wand.power,1e-9)
    }

    @Test
    fun `완드 마력은 정상범주(100)를 넘으면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Wand(name = availableName, power = overPower)
        }
    }

    companion object {
        val invalidName = "루카" // 2글자
        val availableName = "루카스" // 3글자
        val availablePower = 0.5
        val invaildPower = 0.4
        val overPower = 101.0
    }
}
