package com.hhp227.kotlinstudy.`05_inheritance`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import com.hhp227.kotlinstudy.`02_instance_class`.MAX_HP
import com.hhp227.kotlinstudy.`03_encapsulation`.Wand
import junit.framework.TestCase.assertTrue
import kotlin.test.Test

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class GreatWizardTest {
    private lateinit var hero: Hero
    private lateinit var wand: Wand
    private lateinit var greatWizard: GreatWizard
    private val outputStream = ByteArrayOutputStream()

    init {
        setup()
    }

    fun setup() {
        hero = Hero("용사", 50)
        wand = Wand("파이어완드", 50.0)
        greatWizard = GreatWizard("간달프", 100, wand)

        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun `힐 - 정상적으로 HP 회복 및 MP 감소`() {
        greatWizard.heal(hero)

        assertEquals(75, hero.hp, "힐 후 Hero HP는 25 증가해야 합니다.")
        assertEquals(145, greatWizard.mp, "힐 후 GreatWizard MP는 5 감소해야 합니다.")
    }

    @Test
    fun `힐 - 마나 부족 시 실패`() {
        greatWizard.mp = 3
        greatWizard.heal(hero)

        assertEquals(3, greatWizard.mp, "MP가 부족하면 감소하지 않아야 합니다.")
        val output = outputStream.toString().trim()
        assertTrue(output.contains("마나가 부족합니다"))
    }

    @Test
    fun `슈퍼 힐 - 정상적으로 전체 회복 및 MP 감소`() {
        hero.hp = 30
        greatWizard.superHeal(hero)

        assertEquals(MAX_HP, hero.hp, "슈퍼 힐은 Hero HP를 전부 회복시켜야 합니다.")
        assertEquals(100, greatWizard.mp, "슈퍼 힐 후 MP는 50 감소해야 합니다.")

        val output = outputStream.toString().trim()
        assertTrue(output.contains("슈퍼 힐을 시전했습니다. 대상 HP: $MAX_HP"))
    }

    @Test
    fun `슈퍼 힐 - MP 부족 시 실패`() {
        greatWizard.mp = 40
        greatWizard.superHeal(hero)

        assertEquals(40, greatWizard.mp, "MP가 부족할 경우 MP는 감소하지 않아야 합니다.")
        val output = outputStream.toString().trim()
        assertTrue(output.contains("마나가 부족합니다"))
    }
}
