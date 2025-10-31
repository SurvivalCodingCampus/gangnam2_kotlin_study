package com.survival.kotlinstudy.`03_encapsulation`

import com.survival.kotlinstudy.`02_instance_class`.name
import org.junit.Test
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

}