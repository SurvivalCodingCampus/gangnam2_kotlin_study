package com.sesac.practice.day04

import org.junit.Test
import kotlin.test.assertEquals

class WizardTest {
    @Test
    fun `Wizard를 생성한다`() {
        // given
        val name = "wizard"
        val hp = 10
        val wand = Wand("wand", 1.1)

        // when
        val wizard = Wizard(name, hp, wand)

        // then
        assertEquals(name, wizard.name)
        assertEquals(hp, wizard.hp)
        assertEquals(wand, wizard.wand)
    }
}
