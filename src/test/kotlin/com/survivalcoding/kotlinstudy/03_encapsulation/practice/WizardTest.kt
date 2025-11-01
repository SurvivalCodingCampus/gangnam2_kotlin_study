package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class WizardTest {

    @Test
    fun `마법사가 잘 생성되는지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        assertEquals(wizard.name, "간달프")
        assertEquals(wizard.hp, 50)
    }

    @Test
    fun `마법사의 이름이 3자 이상인지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = "법사"
        }

        assertEquals(exception.message, "이름이 3자 이상이어야 합니다.")
    }

    @Test
    fun `마법사의 이름이 8자 이하인지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = "위대한 마법사 간달프"
        }

        assertEquals(exception.message, "이름이 8자 이하이어야 합니다.")
    }

    @Test
    fun `이름에 공백이 있는지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = "마법사 간달프"
        }

        assertEquals(exception.message, "이름에 공백이 포함되어 있습니다.")
    }

    @Test
    fun `이름에 특수문자가 포함 되었는지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.name = "간달프!"
        }

        assertEquals(exception.message, "이름에 특수문자가 포함되어 있습니다.")
    }

    @Test
    fun `MP가 0이하 인지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.mp = -1
        }

        assertEquals(exception.message, "MP는 0 이상이어야 합니다.")
    }

    @Test
    fun `MP가 1000이상 인지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        val exception = assertThrows<IllegalArgumentException> {
            wizard.mp = 1001
        }

        assertEquals(exception.message, "MP는 1000 이하이어야 합니다.")
    }

    @Test
    fun `HP가 음수 일 경우 0이 되는지 확인`() {
        val wizard = Wizard(DEFAULT_WIZARD_NAME, DEFAULT_WIZARD_HP, DEFAULT_WIZARD_MP, DEFAULT_WIZARD_WAND)

        wizard.hp = -1

        assertEquals(wizard.hp, 0)
    }

    companion object {
        const val DEFAULT_WIZARD_NAME = "간달프"
        const val DEFAULT_WIZARD_HP = 50
        const val DEFAULT_WIZARD_MP = 0
        val DEFAULT_WIZARD_WAND: Wand? = null
    }
}