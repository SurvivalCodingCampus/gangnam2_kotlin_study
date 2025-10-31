package com.survival.kotlinstudy.`03_encapsulation`

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertNull

class WizardTest {

    @Test
    fun `Wizard 인스턴스 생성 - wand 가 null 일 경우`() {
        // given (준비)
        val name = "마법사"
        val hp = 10
        val wizard = Wizard(name = name, hp = hp, wand = null)

        // when (실행)

        // then (검증)
        assertEquals(name, wizard.name)
        assertEquals(hp, wizard.hp)
        assertNull(wizard.wand)
    }

    @Test
    fun `Wizard 인스턴스 생성 - wand가 있는 경우`() {
        // given (준비)
        val wizardName = "마법사"
        val wandName = "요술 지팡이"
        val hp = 10
        val power = 3.0

        val wand = Wand(name = wandName, power = power)
        val wizard = Wizard(name = wizardName, hp = hp, wand = wand)
        // when (실행)

        // then (검증)
        assertEquals(wizardName, wizard.name)
        assertEquals(hp, wizard.hp)
        assertEquals(wandName, wizard.wand?.name)
        assertEquals(power, wizard.wand?.power)
    }

    @Test
    fun `Wizard의 이름이 3글자 미만이면 예외가 발생한다`() {
        // given (준비)
        val wizard = Wizard(name = "마법사", hp = 100, wand = null)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = "법사"
        }
        // then (검증)
        assertEquals("마법사의 이름은 3글자 이상이어야 합니다", exception.message)
    }

    @Test
    fun `Wizard의 이름을 3글자로 변경할 때 예외가 발생하지 않는다`() {
        // given (준비)
        val wizard = Wizard(name = "대마법사", hp = 100, wand = null)
        val newName = "마법사"

        // when (실행)
        // then (검증)
        assertDoesNotThrow { wizard.name = newName }
        assertEquals(newName, wizard.name)
    }

    @Test
    fun `Wizard의 이름이 null 이면 예외가 발생한다`() {
        // given (준비)
        val wizard = Wizard(name = "마법사", hp = 100, wand = null)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = ""
        }
        // then (검증)
        assertEquals("마법사의 이름은 null 일 수 없습니다", exception.message)
    }

    @Test
    fun `Wizard의 MP는 0 이상이어야 한다`() {
        // given (준비)
        val wizard = Wizard(name = "마법사", hp = 100, wand = null)

        // when (실행)
        val exception = assertThrows<IllegalArgumentException> {
            wizard.mp = -10
        }
        // then (검증)
        assertEquals("마법사의 MP 는 0 이상이어야 합니다", exception.message)
    }

    @Test
    fun `Wizard의 hp가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다`() {
        // given (준비)
        val wizard = Wizard(name = "마법사", hp = 100, wand = null)

        // when (실행)
        wizard.hp = -100

        // then (검증)
        assertEquals(0, wizard.hp)
    }

}