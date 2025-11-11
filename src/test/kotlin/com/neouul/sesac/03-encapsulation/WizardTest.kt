package com.neouul.sesac.`03-encapsulation`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class WizardTest {
    val wand = Wand(VALID_NAME, VALID_POWER)

    @Test
    fun `Wizard 생성자로 인스턴스가 정상적으로 생성된다`() {
        val wizard = Wizard(VALID_NAME, MAX_WIZARD_HP, wand)

        assertEquals(VALID_NAME, wizard.name)
        assertEquals(MAX_WIZARD_HP, wizard.hp)
        assertEquals(MAX_WIZARD_MP, wizard.mp)
        assertTrue(wizard.wand is Wand)
    }

    @Test
    fun `Wizard 생성자에 3문자 미만의 이름이 전달되어, 인스턴스 생성에 실패한다`() {
        assertFailsWith<IllegalArgumentException> { Wizard("", MAX_WIZARD_HP, wand) }
        assertFailsWith<IllegalArgumentException> { Wizard("A", MAX_WIZARD_HP, wand) }
        assertFailsWith<IllegalArgumentException> { Wizard("AB", MAX_WIZARD_HP, wand) }
    }

    @Test
    fun `Wizard 생성자에 음수의 HP가 전달되어, 인스턴스 생성에 실패한다`() {
        assertFailsWith<IllegalArgumentException> { Wizard(VALID_NAME, -1, wand) }
    }

    @Test
    fun `Wizard의 hp에 0 이상의 값을 대입한다`() {
        // given
        val wizard = Wizard(VALID_NAME, MAX_WIZARD_HP, wand)

        // when
        wizard.hp = 10

        // then
        assertEquals(VALID_NAME, wizard.name)
        assertEquals(10, wizard.hp)
        assertEquals(MAX_WIZARD_MP, wizard.mp)
        assertTrue(wizard.wand is Wand)
    }

    @Test
    fun `Wizard의 hp에 음수 대입을 시도하여, hp가 0이 된다`() {
        // given
        val wizard = Wizard(VALID_NAME, MAX_WIZARD_HP, wand)

        // when
        wizard.hp = -10

        // then
        assertEquals(VALID_NAME, wizard.name)
        assertEquals(0, wizard.hp)
        assertEquals(MAX_WIZARD_MP, wizard.mp)
        assertTrue(wizard.wand is Wand)
    }

    @Test
    fun `Wizard의 mp에 0 이상의 값을 대입한다`() {
        // given
        val wizard = Wizard(VALID_NAME, MAX_WIZARD_HP, wand)

        // when
        wizard.mp = 5

        // then
        assertEquals(VALID_NAME, wizard.name)
        assertEquals(MAX_WIZARD_HP, wizard.hp)
        assertEquals(5, wizard.mp)
        assertTrue(wizard.wand is Wand)
    }

    @Test
    fun `Wizard의 mp에 음수 대입을 시도하여, 실패한다`() {
        val wizard = Wizard(VALID_NAME, MAX_WIZARD_HP, wand)

        // then
        assertEquals(VALID_NAME, wizard.name)
        assertEquals(MAX_WIZARD_HP, wizard.hp)
        assertFailsWith<IllegalArgumentException> { wizard.mp = -5 }
        assertTrue(wizard.wand is Wand)
    }
}