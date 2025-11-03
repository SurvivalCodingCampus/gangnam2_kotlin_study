package com.hhp227.kotlinstudy.`03_encapsulation`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class WizardWandTest {
    @Test
    fun `마법사나 지팡이의 이름은 null일 수 없고, 반드시 3문자 이상이어야 한다`() {
        val wand = Wand("지팡이", 10.0)
        val wizard = Wizard("마법사", 0, wand)

        assertFailsWith<IllegalArgumentException> {
            Wand("지팡", 10.0)
        }
        assertFailsWith<IllegalArgumentException> {
            Wizard("법사", 0, wand)
        }
        assertFailsWith<IllegalArgumentException> {
            wand.name = "지팡"
        }
        assertFailsWith<IllegalArgumentException> {
            wizard.name = "법사"
        }
        assertTrue(wand.name.length > 2)
        assertTrue(wizard.name.length > 2)
    }

    @Test
    fun `지팡이의 마력은 '5할' 이상 '100' 이하여야 한다`() {
        val wand = Wand("지팡이", 0.5)

        assertFailsWith<IllegalArgumentException> {
            Wand("지팡이", 0.4)
        }
        assertFailsWith<IllegalArgumentException> {
            Wand("지팡이", 101.0)
        }
        assertFailsWith<IllegalArgumentException> {
            wand.power = 0.4
        }
        assertFailsWith<IllegalArgumentException> {
            wand.power = 101.0
        }
        assertTrue(wand.power in 0.5..100.0)
    }

    @Test
    fun `마법사의 MP는 0이상이어야 한다`() {
        val wand = Wand("지팡이", 10.0)
        val wizard = Wizard("마법사", 0, wand)

        assertFailsWith<IllegalArgumentException> {
            wizard.mp = -1
        }

        wizard.mp = 10

        assertTrue(wizard.mp >= 0)
    }

    @Test
    fun `HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다`() {
        val wand = Wand("지팡이", 10.0)
        val wizard = Wizard("마법사", 0, wand)

        wizard.hp = -1

        assertEquals(0, wizard.hp)
    }
}